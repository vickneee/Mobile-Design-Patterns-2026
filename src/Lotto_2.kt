fun main() {

    println(pickNumber(7))
}

fun pickNumber(low: Int = 1, high: Int = 40): List<Int> {
    return (low..high).shuffled().take(1)
}

fun pickNDistinct(low: Int, high: Int, n: Int): List<Int> {
    return (low..high).shuffled().take(n).sorted()
}

fun numDistinct(list: List<Int>): Set<Int> {
    val list = list.filter { it > 0 }
    return list.toSet()
}
/*
Write function readNDistinct(low: Int,
high: Int, n: Int): List<Int> that
reads from console a line
that contains n distinct integer number
ranging from low and high (inclusive),
separated by commas.
Hints: use readlnOrNull(), .split(),
check .toIntOrNull(), .filterNotNull()
and .all { ... }
*/

//fun readNDistinct(low: Int, high: Int, n: Int): List<Int> {
//    val input = readlnOrNull() ?: return emptyList()
//
//    val numbers = input.split(",").map { it.trim().toIntOrNull() }
//    numbers.distinct()
//}



