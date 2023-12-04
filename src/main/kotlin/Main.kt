import java.io.File

fun main() {
    println("Day 1:")
    println(day1.first())
    println(day1.second())

    println("Day 2:")
    println(day2.first())
    println(day2.second())

    println("Day 3:")
    println(day3.first())

    println("Day 4:")
    println(day4.first())
    println(day4.second())


}

fun readInput(day: String): List<String> {
    return File("src/main/resources/Day${day}.txt").readLines()
}
