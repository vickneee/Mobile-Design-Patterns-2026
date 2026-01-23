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

fun laillinen(rivi: List<Int>, n: Int, alue: IntRange) = rivi.all { it in alue } && rivi.toSet().size == n

fun tarkista(secret: List<Int>, guess: List<Int>): Int? {
    if (!laillinen(rivi = guess, n = 7, 1 .. 40)) return null

    return secret.intersect(guess.toSet()).size
}

fun main() {

    println(arvo(7, 1 .. 20))


}