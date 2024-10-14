package com.hjsaraviad.core.data.comments.remote.api

import com.hjsaraviad.core.data.comments.remote.models.CommentsResponse
import retrofit2.http.GET
import retrofit2.http.Query

const val MOBILE_QUERY = "mobile"

interface CommentsApi {
    @GET("search_by_date")
    suspend fun fetchComments(
        @Query("query") query: String = MOBILE_QUERY,
    ): CommentsResponse
}