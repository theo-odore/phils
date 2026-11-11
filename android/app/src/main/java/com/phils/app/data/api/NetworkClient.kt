package com.phils.app.data.api

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
    val CANDIDATE_URLS = listOf(
        "https://advice-parliamentary-revenues-cloth.trycloudflare.com/",
        "http://192.168.0.106:3010/",
        "http://100.108.115.4:3010/",
        "http://10.0.2.2:3010/"
    )

    val moshi: Moshi by lazy {
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    private class FailoverInterceptor : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val request = chain.request()
            var lastException: IOException? = null

            for (candidate in CANDIDATE_URLS) {
                val candidateUrl = candidate.toHttpUrl()
                val newUrl = request.url.newBuilder()
                    .scheme(candidateUrl.scheme)
                    .host(candidateUrl.host)
                    .port(candidateUrl.port)
                    .build()
                try {
                    val response = chain.proceed(request.newBuilder().url(newUrl).build())
                    if (response.isSuccessful) return response
                    response.close()
                } catch (e: IOException) {
                    lastException = e
                }
            }
            throw lastException ?: IOException("All endpoints unreachable")
        }
    }

    private val okHttpClient: OkHttpClient by lazy {
        val logging = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BASIC
        }
        OkHttpClient.Builder()
            .addInterceptor(FailoverInterceptor())
            .addInterceptor(logging)
            .connectTimeout(5, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .build()
    }

    val api: PhilsApiService by lazy {
        Retrofit.Builder()
            .baseUrl(CANDIDATE_URLS.first())
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(PhilsApiService::class.java)
    }

    fun getShareUrl(discoveryId: String): String = "${CANDIDATE_URLS.first().trimEnd('/')}/d/$discoveryId"
}
