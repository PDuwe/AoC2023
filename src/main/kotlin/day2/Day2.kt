package day2

import readInput

val input = mapInput(readInput("2"))

fun first(): Int {
    val outcomesPerRoundAsResults = input

    var result = 0

    for ((index, game) in outcomesPerRoundAsResults.withIndex()) {
        result += validate(game, index)
    }

    return result
}

fun mapInput(input: List<String>): MutableList<MutableList<GameOutcome>> {
    val outcomesPerRoundRaw: MutableList<List<String>> = mutableListOf()
    val outcomesPerRoundAsResults: MutableList<MutableList<GameOutcome>> = mutableListOf()

    val trimmedRoundResults = input.mapIndexed { index, it -> it.replace("Game ${index + 1}: ", "") }

    trimmedRoundResults.forEach { outcomesPerRoundRaw.add(it.split(";")) }

    outcomesPerRoundRaw.forEach { game ->
        val rounds = mutableListOf<GameOutcome>()
        game.forEach { rounds.add(mapRoundToOutcome(it)) }
        outcomesPerRoundAsResults.add(rounds)
    }

    return outcomesPerRoundAsResults
}

fun second(): Int {
    TODO()
}

fun validate(outcomesPerGame: MutableList<GameOutcome>, index: Int): Int {
    val configuration = GameOutcome(12, 13, 14)

    for (game in outcomesPerGame) {
        if (game.red >= configuration.red ||
            game.green >= configuration.green ||
            game.blue >= configuration.blue) {
            return 0
        }
    }

    return index + 1
}

fun mapRoundToOutcome(input: String): GameOutcome {
    val perColor = input.split(",")
    val blue = perColor.firstOrNull { it.contains("blue") }?.filter { it.isDigit() }?.toIntOrNull()
    val green = perColor.firstOrNull { it.contains("green") }?.filter { it.isDigit() }?.toIntOrNull()
    val red = perColor.firstOrNull { it.contains("red") }?.filter { it.isDigit() }?.toIntOrNull()

    return GameOutcome(blue ?: 0, green ?: 0, red ?: 0)
}

class GameOutcome (
    val red: Int,
    val green: Int,
    val blue: Int
)