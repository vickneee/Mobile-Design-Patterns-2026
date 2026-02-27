import kotlin.math.roundToInt

// Parameter is function

fun weightedTotal(examPoints: Double, homeworkPoints: Double, homeworkWeight: Double = 0.2): Double {
    val examWeight = 1 - homeworkWeight
    return examPoints * examWeight + homeworkPoints * homeworkWeight
}


// Convert total points to final grade (linear interpolation)
fun arvo(pisteet: Double): Int {
    if (pisteet !in 40.0 .. 100.0) return 0
    val arvosana = 0.5 + (pisteet - 40.0) * 4.99 / 60
    return arvosana.roundToInt()
}

// Optional: create a grade function with custom lower bound
fun teeGrade(alaraja: Double): (pisteet: Double) -> Int {
    return { pisteet: Double ->
        val arvosana = 0.5 + (pisteet - alaraja) * 4.99 / (100 - alaraja) // fixed formula
        arvosana.roundToInt()
    }
}

fun main() {
    val examPoints = 75.00
    val homeworkPoints = 100.00
    val total = weightedTotal(examPoints, homeworkPoints) // 20% homework
    println("Weighted total points: %.2f".format(total))

    val grade = arvo(total)
    println("Final grade: $grade")

    // Using teeGrade function
    val gradeFunction = teeGrade(40.0)
    println("Final grade (teeGrade): ${gradeFunction(total)}")
}