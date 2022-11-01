package com.example.kids.data.remote

import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val apiService: ApiService,
) : BaseDataSource() {

    suspend fun getArticles(apiKey: String) =
        getResult {
            apiService.getArticles(apiKey)
        }
}