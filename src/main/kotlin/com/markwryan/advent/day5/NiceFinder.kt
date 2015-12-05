package com.markwryan.advent.day5

import com.markwryan.advent.util.InputUtils
import java.io.InputStreamReader

/**
 * Day 5 Advent of Code
 */
val INPUT_FILE = "src/main/kotlin/com/markwryan/advent/day5/input.txt"
val VOWELS = "([aeiou])\\w*([aeiou])\\w*([aeiou])".toRegex()
val DUPLICATES = "(\\w)\\1+".toRegex()
val BANNED = "(ab)|(cd)|(pq)|(xy)".toRegex()
val DUPLICATE_NON_OVERLAP = "(\\w)(\\w)(\\w*)\\1\\2+".toRegex()
val REPEAT_WITH_GAP = "(\\w)(\\w)\\1+".toRegex()

fun main(args: Array<String>) {
    val input1 = InputUtils().getText(INPUT_FILE)
    val input2 = InputUtils().getText(INPUT_FILE)
    println("Found " + niceFinder(input1))
    println("Found " + improvedNiceFinder(input2))
}

fun niceFinder(input: InputStreamReader): Int {
    var count = 0
    input.forEachLine {
        if (VOWELS.matcher(it).find() && DUPLICATES.matcher(it).find() && !BANNED.matcher(it).find())
            count++
    }
    return count
}

fun improvedNiceFinder(input: InputStreamReader): Int {
    var count = 0
    input.forEachLine {
        if (DUPLICATE_NON_OVERLAP.matcher(it).find() && REPEAT_WITH_GAP.matcher(it).find())
            count++
    }
    return count
}