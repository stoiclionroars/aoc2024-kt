package day01.part02

import java.io.File

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

    val frequencyMap: MutableMap<Int, Int> = HashMap()
    for (n in rightListOfNumber) {
        var count = frequencyMap[n]
        if (count == null) count = 0
        frequencyMap[n] = count + 1
    }

    var similarityScore = 0
    for( value in leftListOfNumber) {
        if (frequencyMap.containsKey(value)) {
            similarityScore += (value * frequencyMap[value]!!)
        }
    }
    println(similarityScore)
}