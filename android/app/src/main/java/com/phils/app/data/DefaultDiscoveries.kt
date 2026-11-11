package com.phils.app.data

import android.content.Context
import android.util.Log
import com.phils.app.data.api.NetworkClient
import com.phils.app.data.api.ServerDiscoveryDto
import com.phils.app.data.api.toDomain
import com.phils.app.model.Discovery
import com.squareup.moshi.Types

object DefaultDiscoveries {
    private const val TAG = "DefaultDiscoveries"
    private val listType = Types.newParameterizedType(List::class.java, ServerDiscoveryDto::class.java)

    fun load(context: Context?): List<Discovery> {
        if (context == null) return emptyList()
        return try {
            val json = context.assets.open("default_discoveries.json").bufferedReader().use { it.readText() }
            val adapter = NetworkClient.moshi.adapter<List<ServerDiscoveryDto>>(listType)
            val dtos = adapter.fromJson(json) ?: emptyList()
            dtos.map { it.toDomain() }
        } catch (e: Exception) {
            Log.e(TAG, "Failed to load default discoveries from assets", e)
            emptyList()
        }
    }
}
