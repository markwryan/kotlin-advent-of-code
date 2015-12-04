package com.markwryan.advent.day2

import com.markwryan.advent.util.InputUtils
import java.io.FileInputStream
import java.io.InputStreamReader

/**
 * Day 2 Answers for Advent of Code
 */
val INPUT_FILE = "src/main/kotlin/com/markwryan/advent/day2/input.txt"

public fun main(args: Array<String>) {
    val text = InputUtils().getText(INPUT_FILE)
    var wrappingTotal = 0
    var ribbonTotal = 0
    text.forEachLine({
        val dims = it.split("x").map { it -> it.toInt() }.sort()
        val dimensions = Triple(first = dims[0], second = dims[1], third = dims[2])
        wrappingTotal += surfaceArea(dimensions) + (extraPaper(dimensions))
        ribbonTotal += perimeterOfSmallestSide(dimensions) + cubicVolume(dimensions)
    })

    println("Wrapping: " + wrappingTotal)
    println("Ribbon: " + ribbonTotal)
}

fun cubicVolume(dims: Triple<Int,Int,Int>) :Int {
    return dims.first * dims.second * dims.third
}

fun perimeterOfSmallestSide(dims: Triple<Int, Int, Int>): Int {
    return (2 * dims.first) + (2 * dims.second)
}

fun extraPaper(dims: Triple<Int, Int, Int>): Int {
    return dims.first * dims.second
}

fun surfaceArea(dims: Triple<Int,Int,Int>): Int {
    return (2 * dims.first * dims.second) + (2 * dims.second * dims.third) + (2 * dims.first * dims.third)
}

