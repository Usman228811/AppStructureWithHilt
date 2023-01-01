package com.example.myfirstapp.data.api.repo

import com.example.myfirstapp.data.api.remote.Posts
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


class PostsRepo
@Inject
constructor(private val posts: Posts) {

    fun getPosts() = flow {
        emit(posts.getPosts())
    }.flowOn(Dispatchers.IO)

}