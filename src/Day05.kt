fun main() {

    fun splitInput(input: List<String>): Pair<List<String>, List<String>> {
        val rules = mutableListOf<String>()
        val pages = mutableListOf<String>()

        var lineIndex = 0
        while (input[lineIndex].isNotEmpty()) {
            rules.add(input[lineIndex])
            lineIndex++
        }

        lineIndex++

        while (lineIndex in input.indices) {
            pages.add(input[lineIndex])
            lineIndex++
        }
        return Pair(rules, pages)
    }

    fun part1(input: List<String>): Int {
        val (rules, pages) = splitInput(input)

        return -1
    }

    fun part2(input: List<String>): Int {
        return -1
    }

    // Test if implementation meets criteria from the description, like:
    //    check(part1(listOf("test_input")) == 1)


    val dayNumber = "05"
    val testInput = readInput("inputs/Day${dayNumber}_test")
    val input = readInput("inputs/Day${dayNumber}")

    val expectedOutputPart1 = 143
    val actualOutputPart1 = part1(testInput)
    check(actualOutputPart1 == expectedOutputPart1) { "Expected $expectedOutputPart1 but received $actualOutputPart1" }
    part1(input).println()

//    val expectedOutputPart2 = 4
//    val actualOutputPart2 = part2(testInput)
//    check(actualOutputPart2 == expectedOutputPart2) { "Expected $expectedOutputPart2 but received $actualOutputPart2" }
//    part2(input).println()
}
