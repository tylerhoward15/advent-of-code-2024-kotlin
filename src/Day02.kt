import kotlin.math.abs

fun main() {

    data class Report(val levels: List<Int>) {
        fun isSafe(): Boolean {
            var decreases = true
            var increases = true
            var gradual = true

            var i = 0
            while (i < levels.size - 1) {
                val curr = levels[i]
                val next = levels[i + 1]

                if (curr < next) decreases = false
                if (curr > next) increases = false
                if (abs(curr - next) !in 1..3) gradual = false

                if ((!decreases && !increases) || !gradual) return false

                i++
            }

            return true
        }
    }

    fun part1(input: List<String>): Int {
        return input.count {
            val report = Report(it.split(" ").map { it.toInt() })
            report.isSafe()
        }
    }

    fun part2(input: List<String>): Int {
        return -1
    }

    // Test if implementation meets criteria from the description, like:
    //    check(part1(listOf("test_input")) == 1)

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("inputs/Day02_test")
    val expectedOutput = 2
    val actualOutput = part1(testInput)
    check(actualOutput == expectedOutput) { "Expected $expectedOutput but received $actualOutput" }

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("inputs/Day02")
    part1(input).println()
//    part2(input).println()
}
