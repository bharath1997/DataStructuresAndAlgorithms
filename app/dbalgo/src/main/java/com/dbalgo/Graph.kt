//package com.dbalgo
//
//import javax.print.attribute.standard.Destination
//
//class Graph<T> {
////    val adjacencyMap: HashMap<T, HashSet<T>> = Map()
//
//    fun addEdge(source: T, destination: T) {
//        adjacencyMap
//            .computeIfAbsent(source)
//            {
//                HashSet()
//            }
//            .add(destination)
//
//        adjacencyMap
//            .computeIfAbsent(destination)
//            {
//                HashSet()
//            }
//            .add(source)
//    }
//
//    override fun toString(): String {
//        StringBuffer().apply {
//            for (key in adjacencyMap.keys) {
//                append("$key -> ")
//                append((adjacencyMap[key]?.joinToString(",", "[")))
//            }
//        }
//    }
//
//}