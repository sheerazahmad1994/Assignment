package com.example.kids.core.repo


import com.example.kids.data.remote.RemoteDataSource
import com.example.kids.data.remote.performGetOperation
import javax.inject.Inject

class ArticlesRepo @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
) {

    fun getArticles(apiKey: String) =
        performGetOperation(
            networkCall = { remoteDataSource.getArticles(apiKey) }
        )


}