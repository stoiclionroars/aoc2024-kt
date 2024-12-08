package day03.part2

import java.io.File

fun trick(input: String, start: String, end: String, newValue: String): String {
    val regex = Regex("""$start.*?$end""")
    return input.replace(regex, newValue)
}

fun main() {
    val input1 = "files/Day03/00_input.txt"
    val input2= "files/Day03/02_input.txt"
    val sample1 = "files/Day03/01_sample.txt"

    val lines = File(input2).bufferedReader().readLines()

    val regex = Regex("""mul\((\d+),\s*(\d+)\)""")

    var sum = 0
    var joinLine = lines.map { it.replace("\n", "") }.joinToString("")
        var newLine = trick(joinLine, "don", "do", "do")
        var newLine2 = trick(newLine, "don", "\n", "\n")

        println(newLine2)
        val matches = regex.findAll(newLine2)
        val multiplications = matches.map { matchResult ->
            val (num1, num2) = matchResult.destructured
            println("${num1.toInt()} ${num2.toInt()}")
            num1.toInt() * num2.toInt()
        }.toList().reduce { acc, i -> acc + i }
        sum += multiplications

    println(sum)
}