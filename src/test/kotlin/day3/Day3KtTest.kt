package day3

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class Day3KtTest {

    @ParameterizedTest
    @CsvSource("1, false", "., false", "$, true", "#, true")
    fun isSymbol(input: Char, outcome: Boolean) {
        assertEquals(outcome, isSymbol(input))
    }
}