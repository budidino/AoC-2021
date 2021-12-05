fun main() {

    class Bingo() {
        var remainingNumbers = mutableSetOf<Int>()
        var rows = mutableListOf<MutableSet<Int>>()
        var isCompleted = false

        fun checkBingo(number: Int): Int? {
            if (isCompleted) { return null }
            if (!remainingNumbers.contains(number)) {
                return null
            }

            remainingNumbers.remove(number)
            for (row in rows) {
                if (row.contains(number)) {
                    row.remove(number)
                    if (row.isEmpty()) {
                        isCompleted = true
                        return remainingNumbers.sum() * number
                    }
                }
            }
            return null
        }
    }

    fun createBoardWithNumbers(numbers: Set<Int>): Bingo {
        val bingo = Bingo()
        bingo.remainingNumbers.addAll(numbers)

        // add rows
        for (row in numbers.chunked(5)) {
            bingo.rows.add(row.toMutableSet())
        }
        // add columns
        for (i in 0 until 5) {
            val values = mutableSetOf<Int>()
            numbers.forEachIndexed { index, value -> if (index % 5 == i) values.add(value) }
            bingo.rows.add(values)
        }
        return bingo
    }

    fun solve(input: List<String>, findFirst: Boolean = true): Int {
        var boards: MutableList<Bingo> = ArrayList()
        val draw = input[0].split(",").map { it.toInt() }

        // construct bingo boards
        var numbers = mutableSetOf<Int>()
        for (i in 2 until input.count()) {
            val row = input[i].trim().replace("  ", " ").split(" ")
            if (row.count() == 1) {
                boards.add(createBoardWithNumbers(numbers))
                numbers.clear()
            } else {
                val rowToSet = row.map { it.toInt() }
                numbers.addAll(rowToSet)
            }
        }
        boards.add(createBoardWithNumbers(numbers))

        var remainingBoards = boards.count()
        for (num in draw) {
            for (board in boards) {
                val result = board.checkBingo(num)
                if (result != null) {
                    if (findFirst) {
                        return result
                    }
                    remainingBoards -= 1
                    if (remainingBoards == 0) {
                        return result
                    }
                }
            }
        }
        return 0
    }

    val testInput = readInput("day4/test")
    check(solve(testInput) == 4512)
    check(solve(testInput, false) == 1924)

    val input = readInput("day4/input")
    println("PART 1: " + solve(input))
    println("PART 2: " + solve(input, false))
}