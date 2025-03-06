package com.example.rekorapp


import androidx.lifecycle.ViewModel

class ScoreViewModel:ViewModel() {
    var scoreA : Int = 0
    var scoreB : Int = 0

    fun incrementSkorA(points: Int = 1) {
        scoreA += points
    }

    fun incrementSkorB(points: Int = 1) {
        scoreB += points
    }
    fun resetSkor() {
        scoreA = 0
        scoreB = 0
    }

}