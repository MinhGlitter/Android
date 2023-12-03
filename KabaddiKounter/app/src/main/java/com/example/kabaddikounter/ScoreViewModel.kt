package com.example.kabaddikounter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScoreViewModel : ViewModel() {
        // Team's A score
    private val _scoreA = MutableLiveData<Int>(0)
    val scoreA : LiveData<Int>
        get() = _scoreA

        // Team B's score
    private val _scoreB = MutableLiveData<Int>(0)
    val scoreB : LiveData<Int>
        get() = _scoreB

        // Plus 1 point
    fun incrementScore(isTeamA: Boolean) {
        if (isTeamA) {
            _scoreA.value = _scoreA.value!! + 1
        } else {
            _scoreB.value = _scoreB.value!! + 1
        }
    }

        // Plus 2 points
    fun doubleIncrementScore(isTeamA: Boolean){
        if (isTeamA){
            _scoreA.value = _scoreA.value!! + 2
        } else {
            _scoreB.value = _scoreB.value!! + 2
        }
    }

        // Reset
    fun resetScore(){
        _scoreA.value = 0
        _scoreB.value = 0
    }

}
