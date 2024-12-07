package day02.part01


import java.io.File

fun main() {
    val sample = "files/Day02/01_sample.txt"
    val input = "files/Day02/02_input.txt"

    val reports = File(input).bufferedReader().readLines()

    var safeReports = 0;
    for(report in reports) {
        val numbers =  report.split(" ").filter { it.isNotEmpty() }.map {it.toInt()}
        var dir: Direction = Direction.START
        safeReports++
        for( (first, second) in numbers.zipWithNext()) {
            val diff = second - first
            if(diff>0 && diff<=3) {
                if(dir.equals(Direction.START)) {
                    dir = Direction.ASC
                } else if(dir.equals(Direction.DESC)){
                    safeReports--
                    break
                }
            } else if(diff<0 && diff>=-3){
                if(dir.equals(Direction.START)) {
                    dir = Direction.DESC
                } else if(dir.equals(Direction.ASC)){
                    safeReports--
                    break
                }
            } else {
                safeReports--
                break
            }
        }

    }
    println(safeReports)
}

enum class Direction {  START, DESC , ASC }