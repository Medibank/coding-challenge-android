package com.example.myapplication.myapplicationtabactivity.presentation.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.myapplication.myapplicationtabactivity.data.model.Article
import com.example.myapplication.myapplicationtabactivity.data.model.ArticlesList
import com.example.myapplication.myapplicationtabactivity.data.model.SourcesList
import com.example.myapplication.myapplicationtabactivity.domain.usecase.*
import com.example.myapplication.myapplicationtabactivity.presentation.Util
import com.example.myapplication.myapplicationtabactivity.presentation.Util.Companion.TAG
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArticleDetailsViewModel(private val app: Application,
                              private val getNewsArticlesUseCase: GetNewsArticlesUseCase,
                              private val saveNewsArticleUseCase: SaveNewsArticleUseCase,
                              private val getSavedNewsUseCase: GetSavedNewsUseCase,
                              private val deleteSavedNewsArticleUseCase: DeleteSavedNewsArticleUseCase,
                              private val getSourcesUseCase: GetSourcesUseCase
                              ): AndroidViewModel(app) {

    val newArticlesList: MutableLiveData<ArticlesList> = MutableLiveData()
    val sourcesList: MutableLiveData<SourcesList> = MutableLiveData()
    val isError: MutableLiveData<Boolean> = MutableLiveData()

    fun getNewsArticles(country: String) = viewModelScope.launch(Dispatchers.IO) {
        try{
            if(Util.isNetworkAvailable(app)) {
                val apiResult = getNewsArticlesUseCase.execute(country)
                newArticlesList.postValue(apiResult)
            } else {
                isError.postValue(true)
            }
        } catch (e:Exception){
           Log.e(TAG, "Exception occurred --$e.message.toString()")
            isError.postValue(true)
        }
    }

    fun saveArticle(article: Article) = viewModelScope.launch {
        saveNewsArticleUseCase.execute(article)
    }

    fun getSavedNews() = liveData{
        getSavedNewsUseCase.execute().collect {
            emit(it)
        }
    }

    fun deleteArticle(article: Article) = viewModelScope.launch {
        deleteSavedNewsArticleUseCase.execute(article)
    }

    fun getSources(country: String) = viewModelScope.launch(Dispatchers.IO) {
        try{
            if(Util.isNetworkAvailable(app)) {
                val apiResult = getSourcesUseCase.execute(country)
                sourcesList.postValue(apiResult)
            } else {
                isError.postValue(true)
            }
        } catch (e:Exception){
            Log.e(TAG, "Exception occurred --$e.message.toString()")
            isError.postValue(true)
        }
    }

}