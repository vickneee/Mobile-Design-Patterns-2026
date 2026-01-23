import kotlin.math.roundToInt

// Parameter is function

fun mapExample(lista: List<String>, jokuF: (s: String) -> String): List<String> {
    val tulos = mutableListOf<String>()

    for (e in lista) {
        tulos.add(jokuF(e))
    }
    return tulos.toList()
}

fun arvo(pisteet: Double): Int {

    if (pisteet !in 40.0 .. 100.0) return 0

    val arvosana = 0.5 + (pisteet - 40) * 4.99 / 60
    return arvosana.roundToInt()

}

fun teeGrade(alaraja: Double) {

}

// (pisteet: Double) -> Int

fun main() {
    // val s = mapExample(listOf("Abba", "Ace Of Base", "Metallica")) { s: String -> s.reversed() }
    // println(s)

    println(arvo(40.0))
}