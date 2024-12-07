package day02.part02

import java.io.File
import kotlin.math.abs

fun main() {
    val sample1 = "files/Day02/01_sample.txt"
    val input = "files/Day02/02_input.txt"
    val sample2 = "files/Day02/03_sample.txt"

    val reports = File(input).bufferedReader().readLines().filter { it.isNotEmpty() }

    var safeReports = 0;
    for(report in reports) {
        val numbers =  report.split(" ").filter { it.isNotEmpty() }.map {it.toInt()}.toIntArray()
        var dir: Direction
        var countHole: Int
        hole@for(j in -1..numbers.size - 1) {
            dir = Direction.START
            countHole = j
            list@for(i in 0..numbers.size - 2 ){
                if(i==j) {
                    continue@list
                }
                var first = i
                var second = i + 1
                if(second==j) {
                    second++
                    if(second>=numbers.size){
                        break
                    }
                }
                val diff = numbers[second] - numbers[first]
                if(diff in 1..3) {
                    if(dir == Direction.START || dir == Direction.ASC) {
                        dir = Direction.ASC
                    } else {
                        countHole++
                        break
                    }
                } else if(diff in -3..-1){
                    if(dir == Direction.START || dir == Direction.DESC) {
                        dir = Direction.DESC
                    } else {
                        countHole++
                        break
                    }
                } else {
                    countHole++
                    break
                }
            }
            if(countHole==j) {
                println("found")
                safeReports++
                break
            } else if (countHole>j){
                println("not found")
            } else {
                println("chupa")
            }

        }

    }
    println(safeReports)
}

enum class Direction {  START, DESC , ASC }