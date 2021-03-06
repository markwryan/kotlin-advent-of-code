package com.markwryan.advent.day1

import com.markwryan.advent.util.InputUtils

/**
 * Day 1 Answers for Advent of Code
 */
val INPUT_FILE = "src/main/kotlin/com/markwryan/advent/day1/input.txt"

fun main(args: Array<String>) {
    val text = InputUtils().getText(INPUT_FILE).readText()
    var count: Int = 0
    var basement: Int = -1
    for ((index, value) in text.withIndex()) {
        if (value == '(') count++
        if (value == ')') count--
        if (count == -1 && basement == -1) basement = index
    }
    println(count)
    println(basement)
}




