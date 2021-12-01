fun main() {
    fun solve(input: List<Int>, size: Int): Int {
        return input.windowed(size) { it.sum() }.zipWithNext().count { it.second > it.first }
    }

    val testInput = readInputInt("day2/test")
    check(solve(testInput, 1) == 7)
    check(solve(testInput, 3) == 5)

    val input = readInputInt("day2/input")
    println("PART 1: " + solve(input, 1))
    println("PART 2: " + solve(input, 3))
}