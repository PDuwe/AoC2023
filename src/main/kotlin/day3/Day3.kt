package day3

import readInput

val input = readInput("3")

fun first(): Int {
    val adjacentFields = fieldsAdjacentToSymbols()
    val numbers: MutableList<Int> = mutableListOf()

    for ((yIndex, row) in adjacentFields.withIndex()) {
        for ((xIndex, field) in row.withIndex()) {
            if (field) {
                val partNumber = getNumberFromIndex(xIndex, yIndex)
                if (partNumber > 0) {
                    numbers.add(partNumber)
                }
            }
        }
    }

    return removeAdjacentDuplicatesAndReturnSum(numbers)
}

fun isSymbol(c: Char): Boolean {
    return !c.isDigit() && c != '.'
}

fun fieldsAdjacentToSymbols(): Array<Array<Boolean>> {
    val result: Array<Array<Boolean>> = Array(input.size) { Array(input.size) {false} }

    for ((lineIndex, line) in input.withIndex()) {
        for ((charIndex, char) in line.withIndex()) {
            if (isSymbol(char)) {
                markAdjacentFields(result, lineIndex, charIndex)
            }
        }
    }

    return result
}

fun markAdjacentFields(toBeMarked: Array<Array<Boolean>>, xAxis: Int, yAxis: Int) {
    toBeMarked[xAxis - 1][yAxis - 1] = true
    toBeMarked[xAxis][yAxis - 1] = true
    toBeMarked[xAxis + 1][yAxis - 1] = true
    toBeMarked[xAxis - 1][yAxis] = true
    toBeMarked[xAxis][yAxis] = true
    toBeMarked[xAxis + 1][yAxis] = true
    toBeMarked[xAxis - 1][yAxis + 1] = true
    toBeMarked[xAxis][yAxis + 1] = true
    toBeMarked[xAxis + 1][yAxis + 1] = true
}

fun getNumberFromIndex(x: Int, y: Int): Int {
    if (!input[y][x].isDigit()) {
        return 0
    } else {
        if (input[y][x - 2].isDigit()) {
            return if (input[y][x - 1].isDigit() && input[y][x].isDigit()) {
                input[y][x - 2].digitToInt() * 100 + input[y][x - 1].digitToInt() * 10 + input[y][x].digitToInt()
            } else if (input[y][x - 1].isDigit()) {
                input[y][x - 2].digitToInt() * 10 + input[y][x - 1].digitToInt()
            } else return 0
        } else if (input[y][x - 1].isDigit()) {
            return if (input[y][x].isDigit() && input[y][x + 1].isDigit()) {
                input[y][x - 1].digitToInt() * 100 + input[y][x].digitToInt() * 10 + input[y][x + 1].digitToInt()
            } else if (input[y][x].isDigit()) {
                input[y][x - 1].digitToInt() * 10 + input[y][x].digitToInt()
            } else input[y][x - 1].digitToInt()
        } else {
            return if (input[y][x + 1].isDigit() && input[y][x + 2].isDigit()) {
                input[y][x].digitToInt() * 100 + input[y][x + 1].digitToInt() * 10 + input[y][x + 2].digitToInt()
            } else if (input[y][x + 1].isDigit()) {
                input[y][x].digitToInt() * 10 + input[y][x + 1].digitToInt()
            } else if (input[y][x + 2].isDigit()) input[y][x + 2].digitToInt()
            else 0
        }
    }
}

fun removeAdjacentDuplicatesAndReturnSum(listWithDuplicates: MutableList<Int>): Int {
    return listWithDuplicates.zipWithNext()
        .filter { it.first != it.second }.sumOf { it.first }
        .plus(listWithDuplicates.last())
}