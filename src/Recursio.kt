
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
}