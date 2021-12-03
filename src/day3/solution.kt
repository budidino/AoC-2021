fun main() {
    fun part1(input: List<String>): Int {
        val len = input[0].length
        val numbers = input.count().toDouble()
        var sums = IntArray(len)

        for (i in 0..(len-1)) {
            for (row in input) {
                val num = row.get(i).digitToInt()
                sums[i] += num
            }
        }

        var gammaBinary = ""
        var epsilonBinary = ""
        for (n in sums) {
            gammaBinary += if (n/numbers >= 0.5) "1" else "0"
            epsilonBinary += if (n/numbers >= 0.5) "0" else "1"
        }

        return binToDec(gammaBinary.toLong()) * binToDec(epsilonBinary.toLong())
    }

    fun returnDominantBinaryAtIndex(index: Int, list: List<String>): String {
        var sum = 0.0
        for (row in list) {
            sum += row.get(index).digitToInt()
        }
        return if (sum/list.count() >= 0.5) "1" else "0"
    }

    fun returnBinary(input: List<String>, isDominant: Boolean = true): Long {
        var list = input
        for (i in 0..(list[0].length - 1)) {
            val dominant = returnDominantBinaryAtIndex(i, list).single()
            list = list.filter { if (isDominant) it.get(i) == dominant else it.get(i) != dominant }

            if (list.count() == 1) {
                return list.first().toLong()
            }
        }
        return 0
    }

    fun part2(input: List<String>): Int {
        return binToDec(returnBinary(input)) * binToDec(returnBinary(input, false))
    }

    val testInput = readInput("day3/test")
    check(part1(testInput) == 198)
    check(part2(testInput) == 230)

    val input = readInput("day3/input")
    println("PART 1: " + part1(input))
    println("PART 2: " + part2(input))
}