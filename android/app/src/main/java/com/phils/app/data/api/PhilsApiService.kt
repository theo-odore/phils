package com.phils.app.data.api

import retrofit2.http.GET
import retrofit2.http.Query

interface PhilsApiService {

    @GET("api/v1/feed")
    suspend fun getFeed(
        @Query("limit") limit: Int = 50,
        @Query("cursor") cursor: String? = null
    ): FeedApiResponse
}
