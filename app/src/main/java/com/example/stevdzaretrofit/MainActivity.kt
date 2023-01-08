package com.example.stevdzaretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.stevdzaretrofit.adapter.MyAdapter
import com.example.stevdzaretrofit.databinding.ActivityMainBinding
import com.example.stevdzaretrofit.databinding.RowLayoutBinding
import com.example.stevdzaretrofit.repository.Repository

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    private val myAdapter by lazy { MyAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
       // viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)


//      binding.button.setOnClickListener{
//      val myNumber = binding.numberEditText.text.toString()
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getPost()
        viewModel.myResponse.observe(this, Observer { response ->
            if(response.isSuccessful){
                binding.textView.text = response.body()?.title!!
            }else {
                binding.textView.text = response.code().toString()
                Toast.makeText(this, response.code(), Toast.LENGTH_SHORT).show()
            }
        })

    }

    private fun setupRecyclerview() {
        binding.recyclerView.adapter = myAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }
}