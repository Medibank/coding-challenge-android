package com.example.myapplication.myapplicationtabactivity.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.myapplicationtabactivity.domain.usecase.*

class MyViewModelFactory(private val app: Application,
                         private val getNewsArticlesUseCase: GetNewsArticlesUseCase,
                         private val saveNewsArticleUseCase: SaveNewsArticleUseCase,
                         private val getSavedNewsUseCase: GetSavedNewsUseCase,
                         private val deleteSavedNewsArticleUseCase: DeleteSavedNewsArticleUseCase,
                        private val getSourcesUseCase: GetSourcesUseCase): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ArticleDetailsViewModel(app,
            getNewsArticlesUseCase,
            saveNewsArticleUseCase,
            getSavedNewsUseCase,
            deleteSavedNewsArticleUseCase,
            getSourcesUseCase) as T
    }
}