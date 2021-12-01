fun main() {
    fun part1(input: List<Int>): Int {
        var result = 0
        var previous = input.first()
        for (num in input) {
            result += if (num > previous) 1 else 0
            previous = num
        }
        return result
    }

    fun part2(input: List<Int>): Int {
        val summedInput = input.windowed(3) { it.sum() }
        return part1(summedInput)
    }

    val testInput = readInputInt("Day01_test")
    check(part1(testInput) == 7)
    check(part2(testInput) == 5)

    val input = readInputInt("Day01")
    println("PART 1: " + part1(input))
    println("PART 2: " + part2(input))
}