package com.example.myfirstapp.data.api.models


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PostsModelItem(
    @SerializedName("body")
    @Expose
    var body: String?,
    @SerializedName("id")
    @Expose
    var id: Int?,
    @SerializedName("title")
    @Expose
    var title: String?,
    @SerializedName("userId")
    @Expose
    var userId: Int?
)