fun main() {
    fun solve(input: List<Int>, isPart2: Boolean = false): Int {
        println("WIP")
        return 1
    }

    val testInput = readInput("test-8")[0].split(",").map { it.toInt() }
    check(solve(testInput) == 37)
//    check(solve(testInput, true) == 168)

    val input = readInput("input-8")[0].split(",").map { it.toInt() }
//    println("PART 1: " + solve(input))
//    println("PART 2: " + solve(input, true))
}