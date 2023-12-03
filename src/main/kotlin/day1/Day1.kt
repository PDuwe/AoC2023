package day1

import readInput

fun first(): Int =
    readInput("1")
        .map { line ->
            line.filter { char -> char.isDigit() }
        }.sumOf { digits ->
            ("${digits.first()}" + "${digits.last()}").toInt()
        }

fun second(): Int =
    mapStringsToNumbers(readInput("1").toMutableList())
        .map { line ->
            line.filter { char -> char.isDigit() }
        }.sumOf { digits ->
            ("${digits.first()}" + "${digits.last()}").toInt()
        }

fun mapStringsToNumbers(input: MutableList<String>): MutableList<String> {
    val stringToNumber = listOf("one", "two", "three", "four", "five", "six", "seven", "eight", "nine")
    val numbersPerLine = mutableListOf<String>()

    for (line in input) {
        var lineBuffer = ""
        for (char in line) {
            lineBuffer += char
            for ((numberIndex, number) in stringToNumber.withIndex()) {
                if (lineBuffer.contains(number)) {
                    lineBuffer = lineBuffer.replace(number, numberIndex.plus(1).toString() + number.last())
                }
            }
        }
        numbersPerLine.add(lineBuffer)
    }

    return numbersPerLine
}
