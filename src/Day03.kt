fun main() {

    fun part1(input: List<String>): Int {
        val reg = "mul\\((\\d+),(\\d+)\\)".toRegex()
        val products = mutableListOf<Int>()
        input.forEach {
            val matches = reg.findAll(it)
            matches.forEach { products.add(it.groupValues[1].toInt() * it.groupValues[2].toInt()) }
        }

        return products.sum()
    }

    fun getMatchesWithDos(input: List<String>): List<String> {
        val retVal = mutableListOf<String>()
        val reg = "(mul\\((\\d+),(\\d+)\\))|(don't\\(\\))|(do\\(\\))".toRegex()
        input.forEach {
            val matches = reg.findAll(it)
            retVal.addAll(matches.map { it.value })
        }

        return retVal
    }

    fun part2(input: List<String>): Int {
        val tokens = getMatchesWithDos(input)
        tokens.forEach { println(it) }

        return -1
    }

    // Test if implementation meets criteria from the description, like:
    //    check(part1(listOf("test_input")) == 1)


    val dayNumber = "03"
    val testInput = readInput("inputs/Day${dayNumber}_test")
    val input = readInput("inputs/Day${dayNumber}")

//    val expectedOutputPart1 = 161
//    val actualOutputPart1 = part1(testInput)
//    check(actualOutputPart1 == expectedOutputPart1) { "Expected $expectedOutputPart1 but received $actualOutputPart1" }
//    part1(input).println()

    val expectedOutputPart2 = 48
    val actualOutputPart2 = part2(testInput)
    check(actualOutputPart2 == expectedOutputPart2) { "Expected $expectedOutputPart2 but received $actualOutputPart2" }
    part2(input).println()
}
