import kotlin.uuid.Uuid.Companion.random

fun arvo(n: Int, alue: IntRange): List<Int>? {
    if (n < 0 || alue.count() < n) return null

//    val numerot: MutableSet<Int> = mutableSetOf()
//
//    while (numerot.size < n) {
//        numerot.add(alue.random())
//    }

//    return numerot.sorted()

    return alue.shuffled().take(n).sorted()
}

fun main() {

    println(arvo(7, 1 .. 20))
}