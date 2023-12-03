package day2

import readInput

fun first(): Int {
    val outcomesPerGameAsResults = mapInput(readInput("2"))

    var result = 0

    for ((index, game) in outcomesPerGameAsResults.withIndex()) {
        result += validateFirstPuzzle(game, index)
    }

    return result
}

fun validateFirstPuzzle(outcomesPerGame: MutableList<GameOutcome>, index: Int): Int {
    val configuration = GameOutcome(12, 13, 14)
    var violationFound = false

    for (round in outcomesPerGame) {
        if (round.red > configuration.red ||
            round.green > configuration.green ||
            round.blue > configuration.blue) {
            violationFound = true
        }
    }

    return if (violationFound) 0 else index + 1
}

fun second(): Int {
    val outcomesPerGameAsResults = mapInput(readInput("2"))

    var result = 0

    for (game in outcomesPerGameAsResults) {
        result += calculatePowerOfMinimumCubesRequired(game)
    }

    return result
}

fun calculatePowerOfMinimumCubesRequired(outcomesPerGame: MutableList<GameOutcome>): Int {
    var minimumRedCubesPerRound = 0
    var minimumGreenCubesPerRound = 0
    var minimumBlueCubesPerRound = 0

    for (round in outcomesPerGame) {
        if (round.red > minimumRedCubesPerRound) {
            minimumRedCubesPerRound = round.red
        }
        if (round.green > minimumGreenCubesPerRound) {
            minimumGreenCubesPerRound = round.green
        }
        if (round.blue > minimumBlueCubesPerRound) {
            minimumBlueCubesPerRound = round.blue
        }
    }

    return GameOutcome(minimumRedCubesPerRound, minimumGreenCubesPerRound, minimumBlueCubesPerRound).calculatePower()
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

fun mapRoundToOutcome(input: String): GameOutcome {
    val perColor = input.split(",")
    val red = perColor.firstOrNull { it.contains("red") }?.filter { it.isDigit() }?.toIntOrNull()
    val green = perColor.firstOrNull { it.contains("green") }?.filter { it.isDigit() }?.toIntOrNull()
    val blue = perColor.firstOrNull { it.contains("blue") }?.filter { it.isDigit() }?.toIntOrNull()

    return GameOutcome(red ?: 0, green ?: 0, blue ?: 0)
}

class GameOutcome (
    val red: Int,
    val green: Int,
    val blue: Int
) {
    fun calculatePower(): Int = this.red * this.green * this.blue
}