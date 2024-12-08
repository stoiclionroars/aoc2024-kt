package day03.part1

import java.io.File


fun main() {
    val input = "files/Day03/00_input.txt"
    val sample1 = "files/Day03/01_sample.txt"

    val lines = File(input).bufferedReader().readLines()

    val regex = Regex("""mul\((\d+),\s*(\d+)\)""")

    var sum = 0
    for(line in lines ) {
        val matches = regex.findAll(line)
        val multiplications = matches.map { matchResult ->
            val (num1, num2) = matchResult.destructured
            num1.toInt() * num2.toInt()
        }.toList().reduce { acc, i -> acc + i }
        sum += multiplications
    }
    println(sum)
}