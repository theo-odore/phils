package com.phils.app.data.api

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface PhilsApiService {

    @GET("api/v1/feed")
    suspend fun getFeed(
        @Query("limit") limit: Int = 10,
        @Query("cursor") cursor: String? = null
    ): FeedApiResponse

    @POST("api/v1/feed/generate")
    suspend fun generateBatch(
        @Body body: Map<String, Int>
    ): FeedApiResponse
}
