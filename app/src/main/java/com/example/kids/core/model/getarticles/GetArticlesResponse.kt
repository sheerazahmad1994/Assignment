package com.example.kids.core.model.getarticles

data class GetArticlesResponse(
    val copyright: String,
    val num_results: Int,
    val results: ArrayList<Result>,
    val status: String
)