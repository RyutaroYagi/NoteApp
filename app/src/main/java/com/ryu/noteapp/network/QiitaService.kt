package com.ryu.noteapp.network

import com.ryu.noteapp.model.Article
import retrofit2.Response
import retrofit2.http.GET

interface QiitaService {
    @GET("items")
    suspend fun fetchArticles(): Response<List<Article>>
}
