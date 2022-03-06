package com.ryu.noteapp.repository

import com.ryu.noteapp.model.Article
import com.ryu.noteapp.network.QiitaService
import com.ryu.noteapp.utils.Future
import com.ryu.noteapp.utils.apiFlow
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HomeRepository @Inject constructor(private val qiitaService: QiitaService) {

    suspend fun fetchArticles(): Flow<Future<List<Article>>> =
        apiFlow { qiitaService.fetchArticles() }
}