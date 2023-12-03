import java.io.File

fun main(args: Array<String>) {
    println(day1.first())
    println(day1.second())

//    println(day2.first())
//
//    println(day3.first())

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
}

fun readInput(day: String): List<String> {
    return File("src/main/resources/Day${day}.txt").readLines()
}
