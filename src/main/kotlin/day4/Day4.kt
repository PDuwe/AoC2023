package day4

import readInput

val input = parseInput(readInput("4"))
val winningNumbers = input
    .map { it[1] }
    .map { it.split(" ")
        .map { it
            .filter { char ->
                char.isDigit() } }
        .filter { it.isNotEmpty() }
        .map { it.toInt() } }

val drawnNumbers = input
    .map { it[0] }
    .map { it.split(" ")
        .map { it.filter { char ->
            char.isDigit() } }
        .filter { it.isNotEmpty() }
        .map { it.toInt() } }

var amountOfWinningCards = drawnNumbers.size
var copies = mutableListOf<Int>()

fun first(): Int {
    var winningPoints = 0
    for ((index, numbers) in drawnNumbers.withIndex()) {
        winningPoints += determineWinnersPerCard(numbers, index)
    }

    return winningPoints
}

// ToDo: this needs serious refactoring, since the performance is terrible.
fun second(): Int {

    for ((index, numbers) in drawnNumbers.withIndex()) {
        returnWinnerNumbersPerCard(numbers, index).onEach {
            copies.add(it)
        }
    }

    while (copies.size > 0) {
        returnWinnerNumbersPerCard(drawnNumbers[copies[0] - 1], copies[0] - 1).onEach {
            copies.add(it)
        }
        copies.removeAt(0)
    }

    return amountOfWinningCards
}

fun parseInput(readInput: List<String>): List<List<String>> {
    return readInput
        .map { line -> line.replaceFirst("\\s+".toRegex(), " ") }
        .mapIndexed { index, line ->
            line.replace("Card ${index + 1}: ", "") }
        .map { line -> line.split("|") }
}

fun determineWinnersPerCard(cardsPerRound: List<Int>, card: Int): Int {
    val winners = cardsPerRound.filter { winningNumbers[card].contains(it) }.size
    return if (winners > 0) 2.toBigInteger().pow(winners - 1).toInt() else 0
}

fun returnWinnerNumbersPerCard(cardsPerRound: List<Int>, card: Int): List<Int> {
    val winnerNumbers = mutableListOf<Int>()

    cardsPerRound.filter { winningNumbers[card].contains(it) }
        .forEachIndexed { index, _ ->
        winnerNumbers.add(card + 1 + index + 1)
    }

    amountOfWinningCards += winnerNumbers.size

    return winnerNumbers.toList()
}