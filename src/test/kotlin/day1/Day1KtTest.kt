package day1

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day1KtTest {

    val testInput = mutableListOf("twoonej26",
        "sgoneightfoureight5sevenjzsqghg",
        "oneightsevenine",
        "fiveseven5four",
        "seven3lbcvjxqhhdpzkttqsixjzzjjbclfq1fiveightwojx",
        "6bjztkxhsixkgnkroneightht")

    @Test
    fun mapStringsToNumbers() {
        val result = day1.mapStringsToNumbers(testInput)
        assertEquals("21j26", result[0])
        assertEquals("sg1ight4857jzsqghg", result[1])
        assertEquals("1ight7ine", result[2])
        assertEquals("5754", result[3])
        assertEquals("73lbcvjxqhhdpzkttq6jzzjjbclfq15igh2jx", result[4])
        assertEquals("6bjztkxh6kgnkr1ightht", result[5])
    }
}