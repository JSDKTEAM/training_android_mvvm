package com.example.myapplication.presentation.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

class HomeViewModel : ViewModel(),CoroutineScope {

    private val job = Job()
    override val coroutineContext: CoroutineContext = job + Dispatchers.Main

    private var currentNumber = 0

    val showCurrentNumber = MutableLiveData<Int>()

    fun onBtnIncreaseClick(){
        currentNumber++
        showCurrentNumber.value = currentNumber
    }
}