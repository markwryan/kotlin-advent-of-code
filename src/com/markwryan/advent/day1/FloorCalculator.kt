package com.markwryan.advent.day1

import java.io.File
import java.io.FileInputStream
import java.io.FileReader
import java.io.InputStreamReader

/**
 * Created by maryan on 12/3/15.
 */
public fun main(args: Array<String>) {
    val text = getText("src/com/markwryan/advent/day1/input.txt")
    var count: Int = 0
    var basement: Int = -1
    for((index, value) in text.withIndex()) {
        if(value == '(') count++
        if(value == ')') count--
        if(count == -1 && basement == -1) basement = index
    }
    println(count)
    println(basement)
}

public fun getText(input: String): String{
    val stream = FileInputStream(input).buffered()
    return InputStreamReader(stream, "UTF-8").readText()
}




