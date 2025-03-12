package com.example.rekorapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScoreViewModel : ViewModel() {

    private val _scoreA = MutableLiveData(0)
    val scoreA: LiveData<Int> = _scoreA

    private val _scoreB = MutableLiveData(0)
    val scoreB: LiveData<Int> = _scoreB

    private val _winner = MutableLiveData<String?>()
    val winner: LiveData<String?> = _winner

    fun incrementSkorA(points: Int = 1) {
        _scoreA.value = (_scoreA.value ?: 0) + points
        checkWinner()
    }

    fun incrementSkorB(points: Int = 1) {
        _scoreB.value = (_scoreB.value ?: 0) + points
        checkWinner()
    }

    fun resetSkor() {
        _scoreA.value = 0
        _scoreB.value = 0
        _winner.value = null
    }

    private fun checkWinner() {
        if ((_scoreA.value ?: 0) >= 25) {
            _winner.value = "Tim A Menang!"
        } else if ((_scoreB.value ?: 0) >= 25) {
            _winner.value = "Tim B Menang!"
        }
    }
}
