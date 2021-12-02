fun main() {
    fun part1(input: List<String>): Int {
        var x = 0
        var y = 0
        for (row in input) {
            val split = row.split(" ")
            val direction = split[0]
            val distance = split[1].toInt()
            if (direction == "forward") {
                x += distance
            } else {
                y += if (direction == "up") -distance else distance
            }
        }
        return x * y
    }

    fun part2(input: List<String>): Int {
        var x = 0
        var y = 0
        var aim = 0
        for (row in input) {
            val split = row.split(" ")
            val direction = split[0]
            val distance = split[1].toInt()
            if (direction == "forward") {
                x += distance
                y += aim * distance
            } else {
                aim += if (direction == "up") -distance else distance
            }
        }
        return x * y
    }

    val testInput = readInput("day2/test")
    check(part1(testInput) == 150)
    check(part2(testInput) == 900)

    val input = readInput("day2/input")
    println("PART 1: " + part1(input))
    println("PART 2: " + part2(input))
}