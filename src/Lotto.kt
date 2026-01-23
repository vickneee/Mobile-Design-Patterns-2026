import kotlin.uuid.Uuid.Companion.random

fun arvo(n: Int, alue: IntRange): List<Int>? {
    if (n < 0 || alue.count() < n) return null

    val numerot: MutableList<Int> = mutableListOf()

    while (numerot.size < n) {
        val uusiNumero = alue.random()
        if (uusiNumero !in numerot) {
            numerot.add(uusiNumero)
        }
    }

    return numerot
}

fun main() {

    println(arvo(34, 1 .. 20))
}