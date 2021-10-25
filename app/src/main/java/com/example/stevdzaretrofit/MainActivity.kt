package com.example.stevdzaretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.stevdzaretrofit.databinding.ActivityMainBinding
import com.example.stevdzaretrofit.databinding.RowLayoutBinding
import com.example.stevdzaretrofit.repository.Repository

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)


        binding.button.setOnClickListener{
            val myNumber = binding.numberEditText.text.toString()
            viewModel.getPost2(Integer.parseInt(myNumber))
            viewModel.myResponse2.observe(this, Observer { response ->
                if(response.isSuccessful) {
                    binding.textView.text = response.body().toString()
                } else {
                    binding.textView.text = response.code().toString()
                }
            })
        }
    }
}