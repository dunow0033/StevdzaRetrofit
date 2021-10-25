package com.example.stevdzaretrofit.repository

import com.example.stevdzaretrofit.api.RetrofitInstance
import com.example.stevdzaretrofit.model.Post
import retrofit2.Response

class Repository {
    suspend fun getPost(): Response<Post> {
        return RetrofitInstance.api.getPost()
    }

    suspend fun getPost2(number: Int): Response<Post> {
        return RetrofitInstance.api.getPost2(number)
    }
}