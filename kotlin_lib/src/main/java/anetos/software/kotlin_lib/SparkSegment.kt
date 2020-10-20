package anetos.software.kotlin_lib

object SparkSegment {
    fun spark(length: Int): String {
        if (length == 0) return ""
        var pre = "X"
        for (i in 0 until length) {
            pre = pre + "~"
        }
        return pre
    }

    fun freeSegments(length: Int): String {
        var suffix = ""
        return if (length == 0) {
            ""
        } else {
            for (i in 0 until length) {
                suffix = suffix + "0"
            }
            suffix
        }
    }

    var traversedPosition = 0
    fun recursive(a: IntArray, position: Int, length: Int): String {
        var position = position
        var pre = ""
        var preTemp = ""
        while (position <= a.size - 1) {
            if (pre.length < length) {
                preTemp = pre
                pre = pre + spark(a[position])
                if (pre.length > length) {
                    return preTemp
                }
            } else {
                break
            }
            position++
            traversedPosition = position
        }
        return pre
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println("KOTLIN")
        val array = intArrayOf(0, 9, 9, 8, 3, 5, 6, 3, 2, 2, 2, 5)
        val width = 10
        for (value in array) {
            if (value + 1 > width) {
                println("\uD83D\uDE14   Element you've added is out of range.")
                System.exit(0)
            }
        }

        var i = 0
        while (i < array.size) {
            val first = array[i] + 1
            if (first == width) {
                println(spark(array[i]))
            } else {
                val output =
                    recursive(array, i, width)
                if (output.length < width) {
                    println(output + freeSegments(width - output.length))
                } else {
                    println(output)
                }
                i = traversedPosition - 1
            }
            i++
        }
    }
}