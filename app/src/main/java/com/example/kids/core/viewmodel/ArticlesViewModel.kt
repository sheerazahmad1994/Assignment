package com.example.kids.core.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.example.kids.core.model.getarticles.GetArticlesResponse

import com.example.kids.core.repo.ArticlesRepo
import com.example.kids.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ArticlesViewModel @Inject constructor(
    private val articlesRepo: ArticlesRepo
) : ViewModel() {

    private val _getArticles = MutableLiveData<String>()

    private val articles = _getArticles.switchMap { apiKey ->
        articlesRepo.getArticles(apiKey)
    }

    val getArticles: LiveData<Resource<GetArticlesResponse>> = articles

    fun setUrl(
        url: String,
    ) {
        _getArticles.value = url
    }
}