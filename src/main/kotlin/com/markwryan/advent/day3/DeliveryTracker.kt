package main.kotlin.com.markwryan.advent.day3

import com.markwryan.advent.util.InputUtils
import java.util.ArrayList

/**
 * Advent of Code Day 3
 * Created by maryan on 12/4/15.
 */

val INPUT_FILE = "src/main/kotlin/com/markwryan/advent/day3/input.txt"

fun main(args: Array<String>) {
    val input = InputUtils().getText(INPUT_FILE).readText()
    val countForOneSanta = mapPresentDelivery(array(Santa(0, 0)), input)
    val countForTwoSantas = mapPresentDelivery(array(Santa(0, 0), Santa(0, 0)), input)
    println("One Santa visits " + countForOneSanta + " homes.")
    println("Two Santas visit " + countForTwoSantas + " homes.")
}

fun mapPresentDelivery(santas: Array<Santa>, directions: String): Int {
    var homes = arrayListOf(Home(0, 0))
    var santaIndex = 0
    for (direction in directions) {
        santaIndex = if (santaIndex >= santas.size()) 0 else santaIndex

        val santa = santas[santaIndex]
        moveSanta(direction, santa, homes)

        santaIndex++
    }
    return homes.size()
}

fun moveSanta(direction: Char, santa: Santa, homes: ArrayList<Home>) {
    when (direction) {
        '^' -> santa.x++
        'v' -> santa.x--
        '<' -> santa.y--
        '>' -> santa.y++
    }
    val home = Home(santa.x, santa.y)
    if (!homes.contains(home)) homes.add(home)
}

data class Santa(var x: Int, var y: Int)
data class Home(val x: Int, val y: Int)
