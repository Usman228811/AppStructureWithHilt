package com.example.myfirstapp.data.api.remote

import com.example.myfirstapp.data.api.models.PostsModelItem
import retrofit2.http.GET

interface Posts {
    @GET("posts")
    suspend fun getPosts(): ArrayList<PostsModelItem>
}