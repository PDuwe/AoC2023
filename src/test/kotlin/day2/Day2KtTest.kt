package day2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource


class Day2KtTest {

    @Nested
    inner class MaptRoundToOutcomeTest {
        @ParameterizedTest
        @CsvSource(
            "3 blue, 4 red:3:0:4",
            "3 green, 4 red:0:3:4",
            "3 blue, 4 green:3:4:0",
            "8 green, 6 blue, 20 red:6:8:20",
            delimiter = ':')
        fun buildsCorrectOutcomes(input: String, red: Int, green: Int, blue: Int) {
            val outcome = GameOutcome(red, green, blue)
            assertEquals(mapRoundToOutcome(input).blue, outcome.blue)
            assertEquals(mapRoundToOutcome(input).green, outcome.green)
            assertEquals(mapRoundToOutcome(input).red, outcome.red)
        }
    }
}