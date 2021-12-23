package com.dbalgo

import kotlin.math.absoluteValue

class CoinChange {
    fun coinChange(coins:Array<Int>,amountToCompute:Int):Int{
        val coinsComputed = IntArray(amountToCompute +1){
            amountToCompute+1
        }
        for(i in coinsComputed){
            println(i)
        }
        coinsComputed[0] = 0
        (1..amountToCompute).forEach {
            for (coin in coins){
                if(it>=coin && coinsComputed[it-coin]<amountToCompute +1 ){
                    val previous = coinsComputed[it-coin]
                    coinsComputed[it] = Math.min(previous+1,coinsComputed[it])
                }
            }
        }
        return coinsComputed.last().let {
            if(it<amountToCompute+1) it else -1
        }
    }
}