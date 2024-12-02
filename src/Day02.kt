fun main() {
    fun part1(input: List<String>): Int {
        return -1
    }

    fun part2(input: List<String>): Int {
        return -1
    }

    // Test if implementation meets criteria from the description, like:
    //    check(part1(listOf("test_input")) == 1)

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("inputs/Day02_test")
    val expectedOutput = 11
    val actualOutput = part1(testInput)
    check(actualOutput == expectedOutput) { "Expected $expectedOutput but received $actualOutput" }

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("inputs/Day02")
    part1(input).println()
//    part2(input).println()
}
