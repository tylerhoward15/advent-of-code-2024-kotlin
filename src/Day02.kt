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

        fun isSafeExceptOne(): Boolean {
            if (isSafe()) return true

            return levels.indices.any {
                val reportWithoutOne = Report(levels.filterIndexed { index, _ -> it != index })
                reportWithoutOne.isSafe()
            }

        }
    }


    fun stringToLevels(string: String): List<Int> {
        return string.split(" ").map { it.toInt() }
    }

    fun part1(input: List<String>): Int {
        return input.count {
            val report = Report(stringToLevels(it))
            report.isSafe()
        }
    }

    fun part2(input: List<String>): Int {
        return input.count {
            val report = Report(stringToLevels(it))
            report.isSafeExceptOne()
        }
    }

    // Test if implementation meets criteria from the description, like:
    //    check(part1(listOf("test_input")) == 1)


    val dayNumber = "02"
    val testInput = readInput("inputs/Day${dayNumber}_test")
    val input = readInput("inputs/Day${dayNumber}")

    val expectedOutputPart1 = 2
    val actualOutputPart1 = part1(testInput)
    check(actualOutputPart1 == expectedOutputPart1) { "Expected $expectedOutputPart1 but received $actualOutputPart1" }
    part1(input).println()

    val expectedOutputPart2 = 4
    val actualOutputPart2 = part2(testInput)
    check(actualOutputPart2 == expectedOutputPart2) { "Expected $expectedOutputPart2 but received $actualOutputPart2" }
    part2(input).println()
}
