import kotlin.math.roundToInt

fun grader(percentages: Triple<Int, Int, Int>): ((Triple<Double, Double, Double>) -> Int?)? {
    val (w1, w2, w3) = percentages

    // Painojen täytyy summautua tasan 100:aan
    if (w1 + w2 + w3 != 100) return null

    return { points: Triple<Double, Double, Double> ->
        val (p1, p2, p3) = points

        // Kaikkien pisteiden täytyy olla välillä 0–100
        if (p1 !in 0.0..100.0 || p2 !in 0.0..100.0 || p3 !in 0.0..100.0) {
            null
        } else {
            // Lasketaan painotettu summa
            val total = p1 * w1 / 100.0 + p2 * w2 / 100.0 + p3 * w3 / 100.0

            // Alle 40 → arvosana 0
            if (total < 40.0) {
                0
            } else {
                // Lineaarinen interpolointi: 40 pistettä → 0.5, 100 pistettä → 5.49
                val intermediate = 0.5 + (total - 40.0) * (4.99 / 60.0)
                intermediate.roundToInt()
            }
        }
    }
}

fun main() {
    // Testi 1: painot eivät summaudu 100 → null
    val g3 = grader(Triple(61, 30, 10))
    if (g3 != null) {
        println(g3(Triple(40.0, 40.0, 40.0)) ?: "N/A")
    } else {
        println("no grader")  // → no grader ✓
    }

    // Testi 2: normaali käyttö
    val g1 = grader(Triple(60, 30, 10))
    if (g1 != null) {
        println(g1(Triple(40.0,  40.0,  40.0))  ?: "N/A")  // → 1 ✓
        println(g1(Triple(100.0, 100.0, 100.0)) ?: "N/A")  // → 5 ✓
        println(g1(Triple(100.0, 11.0,  0.0))   ?: "N/A")  // → 2 ✓
    }

    // Testi 3: pisteet yli 100 → null
    val g2 = grader(Triple(70, 20, 10))
    if (g2 != null) {
        println(g2(Triple(40.0,  40.0,  40.0))  ?: "N/A")  // → 1 ✓
        println(g2(Triple(67.1, 100.0, 100.0)) ?: "N/A")  // → 5 ✓
        println(g2(Triple(100.0, 110.0, 0.0))   ?: "N/A")  // → N/A ✓
    }

    // Minimipisteet kullekin arvosanalle
    println("\nMinimipisteet arvosanoille (g1, painot 80/20/0):")
    if (g1 != null) {
        for (targetGrade in 1..5) {
            var p = 0.0
            while (p <= 100.0) {
                val grade = g1(Triple(p, p, p))
                if (grade == targetGrade) {
                    println("Arvosana $targetGrade: ~${"%.1f".format(p)} pistettä per komponentti (yhteensä ~${"%.1f".format(p)})")
                    break
                }
                p += 0.01
            }
        }
    }
}