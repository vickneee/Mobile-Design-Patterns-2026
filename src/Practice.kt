class ABCD(val a: Int, val b: Int, c: Int) { // data ei salli ilman val var c: Int parameter
    val d = 2 * c
    val e
        get() =  d -6


    override fun equals(other: Any?): Boolean {
        if (other is ABCD) {
            return this.a == other.a && this.d == other.d
        }
        else {
            return false
        }
    }

    override fun hashCode(): Int {
        return this.a.hashCode() + this.d.hashCode()
    }

    // Equals and Hascode pitää käyttää samoja ominnaisuuksia
}

fun main() {

    val a = ABCD(1,2, 3)
    val b = ABCD(1,2, 3)
    a.a
    a.b
//     a.c Ei ole ominaisuus vain parameter
    a.d
    a.e

    val s = setOf(a, b)
    println(s.size)

    val v = setOf("a", "b", "a")
    println(v.size)

    val a1 = Pair(1, "one")
    val a2 = 1 to "one"
    println(a2)

    val a111 = a1.second
    val (a11, a21) = a1
    println("a111: $a111")
    println("a1: $a1")

    val b1 = Triple(1, "eng", "one")
    val b3 = b1.third
    val (b11, _, b13) = b1
    println(b3)

}
