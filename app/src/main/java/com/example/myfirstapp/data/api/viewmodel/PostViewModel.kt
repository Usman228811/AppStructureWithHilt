package com.example.myfirstapp.data.api.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myfirstapp.data.api.models.PostsModelItem
import com.example.myfirstapp.data.api.repo.PostsRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel
@Inject
constructor(private val repo: PostsRepo) : ViewModel() {

    private val _postsList = MutableLiveData<ArrayList<PostsModelItem>>()
    val postsList = _postsList

    init {
        fetchPosts()
    }

    private fun fetchPosts() {
        viewModelScope.launch {
            repo.getPosts().collect {
                postsList.value = it
            }
        }
    }
}