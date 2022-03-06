package com.ryu.noteapp.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Article(
    val title: String?,
    val url: String?,
    val user: User?,
)

@JsonClass(generateAdapter = true)
data class User(
    val name: String?,
    val description: String?
)
