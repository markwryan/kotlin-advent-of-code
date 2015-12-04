package com.markwryan.advent.day2

import com.markwryan.advent.util.InputUtils
import java.io.FileInputStream
import java.io.InputStreamReader

/**
 * Day 2 Answers for Advent of Code
 */
val INPUT_FILE = "src/main/kotlin/com/markwryan/advent/day2/input.txt"

fun main(args: Array<String>) {
    val text = InputUtils().getText(INPUT_FILE)
    var wrappingTotal = 0
    var ribbonTotal = 0
    text.forEachLine({
        //sorted, so 'length' & 'width' are always the smallest sides
        val (length, width, height) = it.split("x").map { it -> it.toInt() }.sort()
        wrappingTotal += surfaceArea(length, width, height) + (extraPaper(length, width))
        ribbonTotal += perimeterOfSmallestSide(length, width) + cubicVolume(length, width, height)
    })

    println("Wrapping: " + wrappingTotal)
    println("Ribbon: " + ribbonTotal)
}

fun cubicVolume(length: Int, width: Int, height: Int) :Int {
    return length * width * height
}

fun perimeterOfSmallestSide(smallest: Int, secondSmallest: Int): Int {
    return (2 * smallest) + (2 * secondSmallest)
}

fun extraPaper(smallest: Int, secondSmallest: Int): Int {
    return smallest * secondSmallest
}

fun surfaceArea(length: Int, width: Int, height: Int): Int {
    return (2 * length * width) + (2 * width * height) + (2 * length * height)
}

