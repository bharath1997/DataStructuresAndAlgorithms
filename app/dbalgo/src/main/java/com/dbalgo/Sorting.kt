package com.dbalgo

import kotlin.math.min

class Sorting {

    /** Time Complexity Best - o(n), Average - o(n^2), Worst - o(n^2) **/
    fun bubbleSort(arrayInput: Array<Int>): Array<Int> {
        var swap = true
        while(swap){
            swap = false
            for(i in 0 until arrayInput.size-1){
                if(arrayInput[i]>arrayInput[i+1]){
                    val temp = arrayInput[i]
                    arrayInput[i] = arrayInput[i+1]
                    arrayInput[i+1] = temp
                    swap = true
                }
            }
        }
        return arrayInput
    }

    /** Time Complexity Best - o(n^2), Average - o(n^2), Worst - o(n^2) **/
    fun selectionSort(arrayInput: Array<Int>) {
        var size = arrayInput.size
        var temp: Int
        for (i in size - 1 downTo 0) {
            var maxIndex = i
            for (j in 0 until i) {
                if (arrayInput[j] > arrayInput[maxIndex]) {
                    maxIndex = j
                }
            }
            if (i != maxIndex) {
                temp = arrayInput[i]
                arrayInput[i] = arrayInput[maxIndex]
                arrayInput[maxIndex] = temp
            }
        }
    }

    /** Time Complexity Best - o(n^2), Average - o(n^2), Worst - o(n^2) **/
    fun selectionSort2(arrayInput: Array<Int>) {
        var size = arrayInput.size
        var temp: Int
        for (i in 0 until size) {
            var minIndex = i
            for (j in size - 1 downTo i) {
                if (arrayInput[j] < arrayInput[minIndex]) {
                    minIndex = j
                }
            }
            if (i != minIndex) {
                temp = arrayInput[i]
                arrayInput[i] = arrayInput[minIndex]
                arrayInput[minIndex] = temp
            }
        }
    }

    /** Time Complexity Best - o(n), Average - o(n^2), Worst - o(n^2) **/
    fun insertionSort(arrayInput: Array<Int>) {
        var size = arrayInput.size
        var previousIndex: Int
        for (i in 1 until size) {
            var value = arrayInput[i]
            previousIndex = i - 1
            while (previousIndex >= 0 && arrayInput[previousIndex] > value) {
                arrayInput[previousIndex + 1] = arrayInput[previousIndex]
                previousIndex--
            }
            arrayInput[previousIndex + 1] = value
        }
    }

    /** Time Complexity Best - o(n log n), Average - o(n log n), Worst - o(n log n) **/
    fun mergeSort(list: List<Int>): List<Int> {
        if (list.size <= 1) {
            return list
        }
        val middleIndex = list.size / 2
        val leftSublist = list.subList(0, middleIndex)
        val rightSublist = list.subList(middleIndex, list.size)
        return merge(mergeSort(leftSublist), mergeSort(rightSublist))
    }

    private fun merge(leftSubList: List<Int>, rightSublist: List<Int>): List<Int> {
        var leftIndex = 0
        var rightIndex = 0
        var newList = mutableListOf<Int>()
        while (leftIndex < leftSubList.count() && rightIndex < rightSublist.count()) {
            if (leftSubList[leftIndex] <= rightSublist[rightIndex]) {
                newList.add(leftSubList[leftIndex])
                leftIndex++
            } else {
                newList.add(rightSublist[rightIndex])
                rightIndex++
            }
        }
        while (leftIndex < leftSubList.size) {
            newList.add(leftSubList[leftIndex])
            leftIndex++
        }

        while (rightIndex < rightSublist.size) {
            newList.add(rightSublist[rightIndex])
            rightIndex++
        }

        return newList
    }

    /** Time Complexity Best - o(n log n), Average - o(n log n), Worst - o(n^2) **/
    fun quickSort(list: List<Int>): List<Int> {
        if (list.count() < 2) {
            return list
        }
        val pivot = list[list.count() / 2]
        val equalItems = list.filter { it == pivot }
        val greaterItems = list.filter { it > pivot }
        val lesserItems = list.filter { it < pivot }
        return quickSort(lesserItems) + equalItems + quickSort(greaterItems)
    }
}