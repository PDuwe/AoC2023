package day2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource


class Day2KtTest {

    @Nested
    inner class MapRoundToOutcomeTest {
        @ParameterizedTest
        @CsvSource(
            "3 blue, 4 red:4:0:3",
            "3 green, 4 red:4:3:0",
            "3 blue, 4 green:0:4:3",
            "6 blue, 16 green:0:16:6",
            "9 blue, 13 green, 1 red:1:13:9",
            "8 green, 6 blue, 20 red:20:8:6",
            delimiter = ':')
        fun buildsCorrectOutcomes(input: String, red: Int, green: Int, blue: Int) {
            val outcome = GameOutcome(red, green, blue)
            assertEquals(outcome.red, mapRoundToOutcome(input).red)
            assertEquals(outcome.green, mapRoundToOutcome(input).green)
            assertEquals(outcome.blue, mapRoundToOutcome(input).blue)
        }
    }
}