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

fun laillinen(rivi: List<Int>?, n: Int, alue: IntRange): Boolean {
    if (rivi == null) return false
    return rivi.all { it in alue } && rivi.toSet().size == n
}

fun tarkista(secret: List<Int>, guess: List<Int>?): Int? {
    if (!laillinen(rivi = guess, n = 7, 1 .. 40)) return null

    return secret.toSet().intersect(guess?.toSet() ?: setOf()).size
}

fun main() {

    val secret = (1..40).shuffled().take(7)

    println("Arvottu rivi: $secret")

    val guess = arvo(7, 1..40)   // your chosen numbers
    println("Oma rivi: $guess")

    val result = tarkista(secret, guess)

    if (result != null) {
        println("Oikeita numeroita: $result")
    } else {
        println("Virheellinen rivi")
    }
}