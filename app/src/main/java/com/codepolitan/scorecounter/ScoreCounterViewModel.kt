package com.codepolitan.scorecounter

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScoreCounterViewModel : ViewModel() {

//RUMUS DARI LIVEDATA
    private val scoreA :MutableLiveData<Int>? = MutableLiveData()
    private val scoreB :MutableLiveData<Int>? = MutableLiveData()

    fun addScoreA(){
        val result :Int? = getScoreA()?.value?.plus(1)
        scoreA?.value = result
    }
    fun addScoreB(){
        val result :Int? = getScoreB()?.value?.plus(1)
        scoreB?.value = result
    }
    fun minScoreA(){
        val result :Int? =getScoreA()?.value?.minus(1)
        if (result!! <0){
            scoreA?.value =0
        }else{
            scoreA?.value = result
        }
    }
   fun minScoreB(){
        val result :Int? = getScoreB()?.value?.minus(1)
       if (result!! <0){
           scoreB?.value =0
       }else{
           scoreB?.value = result
       }
   }
    fun resetScore(){
        scoreA?.value = 0
        scoreB?.value = 0
    }



    fun getScoreA(): MutableLiveData<Int>? {
        if (scoreA?.value == null) {
//          Main Tgread/ UI Thread
            scoreA?.value = 0
        }
        return scoreA
    }
    fun getScoreB(): MutableLiveData<Int>? {
        if (scoreB?.value == null) {
//          Main Tgread/ UI Thread
            scoreB?.value = 0
        }
        return scoreB
    }
}
