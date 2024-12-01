import kotlin.math.abs

fun getLeftAndRight(input: List<String>): Pair<List<Int>, List<Int>> {
    val left = mutableListOf<Int>()
    val right = mutableListOf<Int>()

    input.forEach {
        val pairRegex = "(\\d+)\\s+(\\d+)".toRegex()
        val matches = pairRegex.find(it) ?: throw Exception("Invalid input")
        left.add(matches.groupValues[1].toInt())
        right.add(matches.groupValues[2].toInt())
    }

    return Pair(left, right)
}

fun part1(input: List<String>): Int {
    val distances = mutableListOf<Int>()
    var (left, right) = getLeftAndRight(input)

    left = left.sorted()
    right = right.sorted()

    left.forEachIndexed { index, _ -> distances.add(abs(right[index] - left[index])) }

    return distances.sum()
}

fun part2(input: List<String>): Int {
    return input.size
}

fun main() {
    // Test if implementation meets criteria from the description, like:
    //    check(part1(listOf("test_input")) == 1)

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("inputs/Day01_test")
    val expectedOutput = 31
    val actualOutput = part2(testInput)
    check(actualOutput == expectedOutput) { "Expected $expectedOutput but received $actualOutput" }

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("inputs/Day01")
//    part1(input).println()
    part2(input).println()
}
