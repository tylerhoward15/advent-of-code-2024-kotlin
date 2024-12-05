fun main() {
    class Puzzle(val puzzleGrid: List<String>) {
        val directions = listOf(
            // row above
            -1 to -1,
            -1 to 0,
            -1 to 1,

            // same row
            0 to -1,
            0 to 1,

            // row below
            1 to -1,
            1 to 0,
            1 to 1,
        )

        val TARGET_STRING = "XMAS"

        fun isValidWord(rowStart: Int, columnStart: Int, direction: Pair<Int, Int>): Boolean {
            if (rowStart !in puzzleGrid.indices || columnStart !in puzzleGrid.indices) {
                return false
            }

            val currentLetter = puzzleGrid[rowStart][columnStart]
            if (currentLetter == TARGET_STRING.last()) {
                return true
            }


            val nextRow = rowStart + direction.first
            val nextColumn = columnStart + direction.second
            if (nextRow !in puzzleGrid.indices || nextColumn !in puzzleGrid.indices) {
                return false
            }

            val nextLetter = puzzleGrid[nextRow][nextColumn]

            if (TARGET_STRING.contains("$currentLetter$nextLetter")) return isValidWord(nextRow, nextColumn, direction)

            return false
        }

        fun getWordCountForPosition(rowStart: Int, columnStart: Int): Int {
            return directions.count { isValidWord(rowStart, columnStart, it) }
        }

        fun getWordCount(): Int {
            var wordCount = 0

            puzzleGrid.indices.forEach { r ->
                puzzleGrid[r].indices.forEach { c ->
                    val firstLetter = puzzleGrid[r][c]
                    if (firstLetter.uppercaseChar() == 'X') wordCount += getWordCountForPosition(r, c)
                }
            }

            return wordCount
        }

    }


    fun part1(input: List<String>): Int {
        val puzzle = Puzzle(input)
        return puzzle.getWordCount()
    }

    fun part2(input: List<String>): Int {
        return -1
    }

    // Test if implementation meets criteria from the description, like:
    //    check(part1(listOf("test_input")) == 1)


    val dayNumber = "04"
    val testInput = readInput("inputs/Day${dayNumber}_test")
    val input = readInput("inputs/Day${dayNumber}")

    val expectedOutputPart1 = 18
    val actualOutputPart1 = part1(testInput)
    check(actualOutputPart1 == expectedOutputPart1) { "Expected $expectedOutputPart1 but received $actualOutputPart1" }
    part1(input).println()

//    val expectedOutputPart2 = 4
//    val actualOutputPart2 = part2(testInput)
//    check(actualOutputPart2 == expectedOutputPart2) { "Expected $expectedOutputPart2 but received $actualOutputPart2" }
//    part2(input).println()
}
