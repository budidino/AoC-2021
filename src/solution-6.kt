fun main() {

    fun solve(input: List<Int>, days: Int): Long {
        val fishes: MutableList<Long> = MutableList(9) {0}
        for (num in input) {
            fishes[num] += 1.toLong()
        }

        for (i in 0 until days) {
            val fishesToAdd = fishes[0]
            fishes.removeAt(0)
            fishes.add(fishesToAdd)
            fishes[6] += fishesToAdd
        }

        return fishes.sumOf { it }
    }

    val testInput = readInput("test-6")[0].split(",").map { it.toInt() }
    check(solve(testInput, 80) == 5934.toLong())
    check(solve(testInput, 256) == 26984457539)

    val input = readInput("input-6")[0].split(",").map { it.toInt() }
    println("PART 1: " + solve(input, 80)) // 360610
    println("PART 2: " + solve(input, 256))
}