package com.example.myapplication.presentation.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_home.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeActivity : AppCompatActivity() {

    private val viewModel: HomeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        initEvent()
        initViewModel()

    }

    private fun initEvent() {
        btnIncrease.setOnClickListener {
            viewModel.onBtnIncreaseClick()
        }
    }

    private fun initViewModel() {
        viewModel.showCurrentNumber.observe(this, Observer { currentNumber ->
            txtNumber.text = currentNumber.toString()
        })
    }
}