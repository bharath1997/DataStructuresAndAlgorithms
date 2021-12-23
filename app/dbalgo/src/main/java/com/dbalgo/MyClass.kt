package com.dbalgo

import java.util.*
import java.util.LinkedList
import kotlin.collections.ArrayList

fun main() {

    /**queue with linked list**/
//    val queue: Queue<String> = LinkedList()
//    queue.add("customer1")
//    queue.add("customer2")
//    queue.add("customer3")
//    println(queue)
//    println(queue.poll())
//    println(queue.peek())
//    println(queue.remove())
//    println(queue.offer("customer offer"))
//    println(queue)
    /** fizz buzz**/
//    println((1..100).map {
//        mapOf(0 to it,it%3 to "fizz",it%5 to "buzz", it%15 to "fizz buzz")[0]
//    })
//    print(reverseString("you are a fucker"))

    /**left or right at k time**/
//    val inputArray = intArrayOf(0, 1, 2, 3, 4, 5, 6)
//    val k = 2
//    val outputArray = inputArray.leftShift(k)
//    val outputRSArray = inputArray.reversedArray().rightShift(k)
//    print(outputArray.joinToString(","))
//    print(outputRSArray.joinToString(","))

    /**find kth largest value in an array**/
//    val testArray = intArrayOf(9, 2, 10, 2, 1, 78, 45, 98)
//    println(testArray.findKLargest(2))

    /**set matrix zero **/

//    val matrix = arrayOf(intArrayOf(1, 2, 3, 4), intArrayOf(2, 5, 4, 0), intArrayOf(1, 5, 5, 7))
//    println(Matrix().spiralMatrix(matrix))
//    val node1 = Node(value = 2)
//    val node2 = Node(value = 3)
//    val node3 = Node(value = 8)
//
//    node1.next = node2
//    node2.next = node3
//    print(node1)

    /**binary tree with nodes**/
//    val listOfElements = arrayOf(20, 30, 80, 70, 5, 4, 90, 28, 35)
//    val tree = BinaryTree.Node(60)
//    for (element in listOfElements) {
//        tree.insert(element)
//    }
//    val node = tree.find(80)
//    println(node)
//    val deleteNode = tree.delete(35)
//    print(deleteNode)

    /**selection sort**/
    val sorting = Sorting()
//    val array = arrayOf(2,4,5,1,2,9,6,5)
    val list = mutableListOf(38, 27, 43, 3, 9, 82, 10)
//    sorting.selectionSort2(array)
//    sorting.insertionSort(array)
   val sortedList = sorting.mergeSort(list)
    for (i in sortedList){
        print("$i ")
    }
}

fun IntArray.findKLargest(k: Int): Int {
    Arrays.sort(this)
    return this[this.size - k]
}

fun IntArray.rightShift(k: Int): IntArray {
    val copyArray = this.copyOf()
    var rotateBy = k
    if (rotateBy > size) {
        rotateBy %= size
    }
    forEachIndexed { index, value ->
        val shiftedIndex = (index + (size - rotateBy)) % size
        copyArray[shiftedIndex] = value
    }
    return copyArray
}

fun IntArray.leftShift(k: Int): IntArray {
    val copyArray = this.copyOf()
    var rotateBy = k
    if (rotateBy > size) {
        rotateBy %= size
    }
    forEachIndexed { index, value ->
        val shiftedIndex = (index + (size - rotateBy)) % size
        copyArray[shiftedIndex] = value
    }
    return copyArray
}

fun reverseString(stringToReverse: String) = stringToReverse.split(" ").reversed().joinToString(" ")


/**Linked list recursion based**/
class Node<T>(val value: T, var next: Node<T>? = null) {
    override fun toString(): String {
        return if (next != null) {
            "$value" + "->${next.toString()}"
        } else {
            "$value"
        }
    }
}

class Matrix {
    fun spiralMatrix(matrix: Array<IntArray>): List<Int> {
        if (matrix.isEmpty() || matrix[0].isEmpty()) {
            return emptyList()
        }
        val numberOfElements = matrix.size * matrix[0].size
        val matrixInSpiralOrder = ArrayList<Int>(numberOfElements)
        val printedElements = Array(matrix.size)
        {
            BooleanArray(matrix[0].size)
        }
        if (matrix.size == 1) {
            matrix[0].mapTo(matrixInSpiralOrder) {
                it
            }
            return matrixInSpiralOrder
        }
        if (matrix[0].size == 1) {
            matrix.mapTo(matrixInSpiralOrder) {
                it[0]
            }
            return matrixInSpiralOrder
        }

        val middleX = if (matrix.size % 2 == 0) {
            (matrix.size - 1) / 2
        } else {
            matrix.size / 2
        }
        val middleY = if (matrix[0].size % 2 == 0) {
            (matrix[0].size - 1) / 2
        } else {
            matrix[0].size / 2
        }
        println("test" + (matrix.size))
        println("testy" + (matrix[0].size))
        println("middlex $middleX")
        println("middley $middleY")
        var row = 0
        var col = 0
        var depth = 0
        while (row <= middleX && col <= middleY && depth <= middleX && depth <= middleY) {
            row = depth
            col = depth
            while (col < matrix[0].size - depth) {
                if (!printedElements[row][col]) {
                    matrixInSpiralOrder.add(matrix[row][col])
                    printedElements[row][col] = true
                }
                col++
            }
            col--
            row++
            while (row < matrix.size - depth) {
                if (!printedElements[row][col]) {
                    matrixInSpiralOrder.add(matrix[row][col])
                    printedElements[row][col] = true
                }
                row++
            }
            row--
            col--
            while (col >= depth) {
                if (!printedElements[row][col]) {
                    matrixInSpiralOrder.add(matrix[row][col])
                    printedElements[row][col] = true
                }
                col--
            }
            col++
            row--
            while (row > depth) {
                if (!printedElements[row][col]) {
                    matrixInSpiralOrder.add(matrix[row][col])
                    printedElements[row][col] = true
                }
                row--
            }
            depth++
        }
        return matrixInSpiralOrder
    }

    fun setMatrixZero(matrix: Array<IntArray>) {
        val rows = matrix.size
        val columns = matrix[0].size
        var firstRow = false
        var firstColumn = false
        for (row in 0 until rows) {
            for (col in 0 until columns) {
                if (matrix[row][col] == 0) {
                    if (row == 0) {
                        firstRow = true
                    }
                    if (col == 0) {
                        firstColumn = true
                    }
                    matrix[row][0] = 0
                    matrix[0][col] = 0
                }
            }
        }
        println(matrix.map { it.toList() })

        for (row in 1 until rows) {
            if (matrix[row][0] == 0) {
                for (col in 1 until columns) {
                    matrix[row][col] = 0
                }
            }
        }
        for (col in 1 until columns) {
            if (matrix[0][col] == 0) {
                for (row in 1 until columns) {
                    matrix[row][col] = 0
                }
            }
        }
        println(matrix.map { it.toList() })
        if (firstRow) {
            for (col in 0 until columns) {
                matrix[0][col] = 0
            }
        }
        if (firstColumn) {
            for (row in 0 until rows) {
                matrix[row][0] = 0
            }
        }
        println(matrix.map { it.toList() })
    }
}