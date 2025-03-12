package com.example.rekorapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScoreViewModel : ViewModel() {

    private val _scoreA = MutableLiveData(0)
    val scoreA: LiveData<Int> = _scoreA

    private val _scoreB = MutableLiveData(0)
    val scoreB: LiveData<Int> = _scoreB

    fun incrementSkorA(points: Int = 1) {
        _scoreA.value = (_scoreA.value ?: 0) + points
    }

    fun incrementSkorB(points: Int = 1) {
        _scoreB.value = (_scoreB.value ?: 0) + points
    }

    fun resetSkor() {
        _scoreA.value = 0
        _scoreB.value = 0
    }
}
