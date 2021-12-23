package com.dbalgo

class LinkedList<T> {
    private var head:Node<T>? = null
    private var tail:Node<T>? = null
    private var size = 0

    private fun isEmpty() = size == 0
    override fun toString(): String {
        return if(isEmpty()){
            "Empty list"
        }else{
            head.toString()
        }
    }


}