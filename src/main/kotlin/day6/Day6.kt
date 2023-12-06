package day6

import readInput

val SPEED_INCREASE_PER_SECOND = 1

val input = readInput("6")

fun first(): Int = parseInput(input).map {
    (1..it.first).filter { second ->
        (it.first - second) * (SPEED_INCREASE_PER_SECOND * second) > it.second
    }.size
}.reduce { acc, i -> acc * i }

fun second(): Int = (1..parseInputPartTwo(input).first).filter { second ->
    ((parseInputPartTwo(input).first - second) * (SPEED_INCREASE_PER_SECOND * second)) > parseInputPartTwo(input).second
}.size

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

fun parseInputPartTwo(readInput: List<String>): Pair<Long, Long> {
    val digits = readInput.map {
        it.filter {
            it.isDigit()
        }
    }.filter {
        it.isNotEmpty()
    }.map { it.toLong() }

    val time = digits[0]
    val distance = digits[1]

    return Pair(time, distance)
}

