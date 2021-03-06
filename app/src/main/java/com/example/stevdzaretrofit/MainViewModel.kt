package com.example.stevdzaretrofit

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.stevdzaretrofit.model.Post
import com.example.stevdzaretrofit.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository): ViewModel() {

    var myResponse: MutableLiveData<Response<Post>> = MutableLiveData()
    var myResponse2: MutableLiveData<Response<Post>> = MutableLiveData()

    fun getPost() {
        viewModelScope.launch {
            val response = repository.getPost()
            myResponse.value = response
        }
    }

    fun getPost2(number: Int) {
        viewModelScope.launch {
            val response = repository.getPost2(number)
            myResponse2.value = response
        }
    }
}