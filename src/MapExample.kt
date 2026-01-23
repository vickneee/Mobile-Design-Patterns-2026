// Parameter is function

fun mapExample(lista: List<String>, jokuF: (s: String) -> String): List<String> {
    val tulos = mutableListOf<String>()

    for (e in lista) {
        tulos.add(jokuF(e))
    }
    return tulos.toList()
}

fun main() {
    val s = mapExample(listOf("Abba", "Ace Of Base", "Metallica")) { s: String -> s.reversed() }
    println(s)
}