package com.example.jorgeberti.clickgame

class Game{
    val step: Long = 1000L
    val initialTime: Long = 10000L
    var count = 0


    fun click(){
        count ++
    }

    fun reset(){
        count = 0
    }
}