fun part1(input: List<String>): Int {
    return input.size
}

fun part2(input: List<String>): Int {
    return input.size
}

fun main() {
    // Test if implementation meets criteria from the description, like:
//    check(part1(listOf("test_input")) == 1)

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("inputs/Day01_test")
    val expectedOutput = 11
    val actualOutput = part1(testInput)
    check(actualOutput == expectedOutput) { "Expected $expectedOutput but received $actualOutput" }

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("inputs/Day01")
    part1(input).println()
    part2(input).println()
}
