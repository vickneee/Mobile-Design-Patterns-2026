data class Suoritus(val op: Int, var ar: Int) {
}

data class Opiskelija(val nro: Int) {
    val suoritukset = mutableListOf<Suoritus>()
}



fun mm(lista: List<String>): List<String> {
    println("Listan pituus: $lista")
    return if (lista.isEmpty()) {
        listOf()
    }
    else {
        mm(lista.drop(1)) + listOf(lista.first())
    }
}

fun main () {
    println(mm(listOf("a","ab","abc")))

    val o = (1 .. 5).map { Opiskelija(it) }
    println(o)
    (1 .. 5).forEach {
        o.forEach { it.suoritukset.add(Suoritus((1..5).random(), (1..5).random())) }
    }
    o.forEach { println(it.suoritukset) }
    
    println(o.map { it.suoritukset.size }.sum())
    o.forEach { it -> it.suoritukset.forEach {it.op} }
}