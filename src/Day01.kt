fun main() {
    fun part1(input: List<Int>): Int {
        return input.zipWithNext().count { it.second > it.first }
    }

    fun part2(input: List<Int>): Int {
        return part1(input.windowed(3) { it.sum() })
    }

    val testInput = readInputInt("Day01_test")
    check(part1(testInput) == 7)
    check(part2(testInput) == 5)

    val input = readInputInt("Day01")
    println("PART 1: " + part1(input))
    println("PART 2: " + part2(input))
}