package com.phils.app.data.api

import android.util.Log
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit

object NetworkClient {
    private const val TAG = "NetworkClient"

    // Candidate base URLs ordered by priority:
    // 1. Cloudflare Tunnel (Global HTTPS, works on cellular anywhere without Wi-Fi)
    // 2. Homeserver Local Wi-Fi (Direct high-speed LAN)
    // 3. Homeserver Tailscale IP
    // 4. Android Emulator loopback
    val CANDIDATE_URLS = listOf(
        "https://advice-parliamentary-revenues-cloth.trycloudflare.com/",
        "http://192.168.0.106:3010/",
        "http://100.108.115.4:3010/",
        "http://10.0.2.2:3010/"
    )

    @Volatile
    var activeHostIndex: Int = 0

    val moshi: Moshi by lazy {
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    private class ResilientHostInterceptor : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val originalRequest = chain.request()
            var lastException: IOException? = null

            for (i in CANDIDATE_URLS.indices) {
                val candidateIndex = (activeHostIndex + i) % CANDIDATE_URLS.size
                val candidateUrl = CANDIDATE_URLS[candidateIndex].toHttpUrl()

                val targetUrl = originalRequest.url.newBuilder()
                    .scheme(candidateUrl.scheme)
                    .host(candidateUrl.host)
                    .port(candidateUrl.port)
                    .build()

                val newRequest = originalRequest.newBuilder().url(targetUrl).build()

                try {
                    val response = chain.proceed(newRequest)
                    if (response.isSuccessful) {
                        activeHostIndex = candidateIndex
                        return response
                    }
                    if (response.code in listOf(502, 503, 504)) {
                        response.close()
                        continue
                    }
                    activeHostIndex = candidateIndex
                    return response
                } catch (e: IOException) {
                    lastException = e
                    Log.d(TAG, "Endpoint ${candidateUrl.host} unreachable, attempting next candidate...")
                }
            }

            throw lastException ?: IOException("All candidate backend servers are unreachable.")
        }
    }

    private val okHttpClient: OkHttpClient by lazy {
        val logging = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BASIC
        }
        OkHttpClient.Builder()
            .addInterceptor(ResilientHostInterceptor())
            .addInterceptor(logging)
            .connectTimeout(5, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .build()
    }

    val api: PhilsApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://advice-parliamentary-revenues-cloth.trycloudflare.com/")
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(PhilsApiService::class.java)
    }

    fun getShareUrl(discoveryId: String): String {
        val base = CANDIDATE_URLS[activeHostIndex].trimEnd('/')
        return "$base/d/$discoveryId"
    }
}
