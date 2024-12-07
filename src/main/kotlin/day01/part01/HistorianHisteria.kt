package day01.part01

import java.io.File
import kotlin.math.abs

fun main() {
    val sample = "files/Day01/01_sample.txt"
    val input  = "files/Day01/02_input.txt"

    val lines = File(input).bufferedReader().readLines()

    val leftListOfNumber = IntArray(lines.size)
    val rightListOfNumber = IntArray(lines.size)

    for((index, line) in lines.withIndex()) {
        val values = line.split(" ")
        leftListOfNumber[index] = values[0].toInt()
        rightListOfNumber[index] = values[3].toInt()
    }
    leftListOfNumber.sort()
    rightListOfNumber.sort()

    var totalOfDifferences = 0
    for((left, right) in leftListOfNumber.zip(rightListOfNumber)) {
        totalOfDifferences += abs(left - right)
    }
    println(totalOfDifferences)
}