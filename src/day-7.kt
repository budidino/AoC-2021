fun main() {

    fun cost(n: Int): Int {
        return (n * (n+1)) / 2
    }

    fun solve(input: List<Int>, growingConsumption: Boolean = false): Int {
        val solutions = mutableSetOf<Int>()
        for (destinationX in input.minOf { it } .. input.maxOf { it }) {
            var fuel = 0
            for (x in input) {
                val diff = kotlin.math.abs(x - destinationX)
                fuel += if (growingConsumption) cost(diff) else diff
            }
            solutions.add(fuel)
        }
        return solutions.minOf { it }
    }

    val testInput = readInput("test-7")[0].split(",").map { it.toInt() }
    check(solve(testInput) == 37)
    check(solve(testInput, true) == 168)

    val input = readInput("input-7")[0].split(",").map { it.toInt() }
    println("PART 1: " + solve(input))
    println("PART 2: " + solve(input, true))
}