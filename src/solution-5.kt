fun main() {

    class Instruction(var startX: Int = 0, var startY: Int = 0, var endX: Int = 0, var endY: Int = 0, var isStraight: Boolean = false)

    fun solve(input: List<String>, onlyStraight: Boolean = true): Int {
        val matrix = Array(999) {Array(999) {0} }
        val instructions: MutableList<Instruction> = ArrayList()
        for (row in input) {
            val commands = row.split(" -> ")
            val instruction = Instruction()

            val startSplit = commands[0].split(",")
            instruction.startX = startSplit[0].toInt()
            instruction.startY = startSplit[1].toInt()

            val endSplit = commands[1].split(",")
            instruction.endX = endSplit[0].toInt()
            instruction.endY = endSplit[1].toInt()

            instruction.isStraight = (instruction.startX == instruction.endX || instruction.startY == instruction.endY)
            instructions.add(instruction)
        }

        for (instruction in instructions) {
            if (!instruction.isStraight && onlyStraight) {  continue  }
            var x = instruction.startX
            var y = instruction.startY
            matrix[x][y] += 1
            while (x != instruction.endX || y != instruction.endY) {
                if (x != instruction.endX) {
                    x += if (x < instruction.endX) 1 else -1
                }
                if (y != instruction.endY) {
                    y += if (y < instruction.endY) 1 else -1
                }
                matrix[x][y] += 1
            }
        }

        var result = 0
        for (row in matrix) {
            for (value in row) {
                if (value > 1) {
                    result += 1
                }
            }
        }

        return result
    }

    val testInput = readInput("test-5")
    check(solve(testInput) == 5)
    check(solve(testInput, false) == 12)

    val input = readInput("input-5")
    println("PART 1: " + solve(input))
    println("PART 2: " + solve(input, false))
}