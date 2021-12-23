package com.dbalgo

import java.lang.IllegalArgumentException
import java.lang.IllegalStateException

class BinaryTree {
    class Node(private var value: Int, var leftChild: Node? = null, var rightChild: Node? = null) {
        fun insert(element: Int) {
            if (element > this.value) {
                if (this.rightChild == null) {
                    this.rightChild = Node(element)
                } else {
                    this.rightChild?.insert(element)
                }
            } else {
                if (this.leftChild == null) {
                    this.leftChild = Node(element)
                } else {
                    this.leftChild?.insert(element)
                }
            }
        }

        fun delete(element: Int) = when {
            this.value > element -> {
                scan(element, this.leftChild, this)
                println("deleted from left subtree")
            }
            this.value < element -> {
                scan(element, this.rightChild, this)
                println("deleted from right subtree")
            }
            else -> {
                removeNode(this, null)
                println("deleted")
            }
        }

        fun removeNode(node: Node, parent: Node?) {
            node.leftChild?.let {
                run {
                    node.rightChild?.let {
                        removeTwoChildren(node)
                    } ?: removeOneChild(node, it)
                }
            } ?: run {
                node.rightChild?.let {
                    removeOneChild(node, it)
                } ?: removeNone(node, parent)
            }

        }

        fun removeNone(node: Node?, parent: Node?) {
            parent?.let {
                if (node == it.leftChild) {
                    it.leftChild = null
                } else if (node == it.rightChild) {
                    it.rightChild = null
                }
            } ?: throw IllegalStateException("cannot remove")
        }

        fun removeOneChild(parent: Node, child: Node) {
            parent.value = child.value
            parent.leftChild = child.leftChild
            parent.rightChild = child.rightChild
        }

        fun removeTwoChildren(node: Node) {
            val left = node.leftChild!!
            left.rightChild.let {
                val maximumParent = findParentOfMaxChild(left)
                maximumParent.rightChild?.let {
                    node.value = it.value
                    maximumParent.rightChild = null
                } ?: throw IllegalStateException("doesnt contain right child")
            } ?: run {
                node.value = left.value
                node.leftChild = left.leftChild
            }
        }

        fun findParentOfMaxChild(node: Node): Node {
            return node.rightChild?.let { left ->
                left.rightChild?.let { findParentOfMaxChild(it) } ?: node
            } ?: throw IllegalArgumentException("right child is null")
        }

        private fun scan(element: Int, node: Node?, parentNode: Node?) {
            if (node == null) {
                println(" doesnt exist")
                return
            }
            when {
                element > node.value -> scan(element, node.rightChild, node)
                element < node.value -> scan(element, node.leftChild, node)
                element == node.value -> removeNode(node, parentNode)
            }
        }

        fun find(element: Int): Node? = when {
            this.value > element -> leftChild?.find(element)
            this.value < element -> rightChild?.find(element)
            else -> this
        }
    }
}