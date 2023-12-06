package day6

import readInput
import java.math.BigInteger

val SPEED_INCREASE_PER_SECOND = 1

val input = readInput("6")

fun first(): Int = parseInput(input).map {
    (1..it.first).filter { second ->
        (it.first - second) * (SPEED_INCREASE_PER_SECOND * second) > it.second
    }.size
}.reduce { acc, i -> acc * i }

fun second(): BigInteger {
    val a = (1..parseInputPartTwo(input).first).filter { second ->
        ((parseInputPartTwo(input).first - second) * (second)).toBigInteger() > parseInputPartTwo(input).second
    }
    return 1.toBigInteger()
}
//
//fun second(): BigInteger = (1..parseInputPartTwo(input).first).filter { second ->
//    ((parseInputPartTwo(input).first.toInt() - second) * (second)) > parseInputPartTwo(input).second
//}.size

fun parseInput(readInput: List<String>): List<Pair<Int, Int>> {
    val digits = readInput.map { it.split("\\s+".toRegex()) }.map {
        it.map {
            it.filter {
                it.isDigit()
            }
        }.filter {
            it.isNotEmpty()
        }.map { it.toInt() }
    }

    val time = digits[0]
    val distance = digits[1]

    return time.zip(distance)
}

fun parseInputPartTwo(readInput: List<String>): Pair<Int, BigInteger> {
    val digits = readInput.map {
            it.filter {
                it.isDigit()
            }
        }.filter {
            it.isNotEmpty()
        }.map { it.toBigInteger() }

    val time = digits[0].toInt()
    val distance = digits[1]

    return Pair(time, distance)
}

