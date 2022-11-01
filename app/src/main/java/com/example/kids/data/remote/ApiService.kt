package com.example.kids.data.remote

import com.example.kids.core.model.getarticles.GetArticlesResponse
import com.example.kids.utils.AppConstants
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @GET(AppConstants.GET_ARTICLES)
    suspend fun getArticles(
        @Query("api-key") api_key: String,
    ): Response<GetArticlesResponse>

}