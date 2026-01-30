class Student2 {

    var grades = listOf<Int>()
    set(value) {
        field = value.filter { it in 1 .. 5 }
    }

    val average
        get() = grades.takeIf { it.isNotEmpty() }?.let { it.sum().toDouble() / it.size }
}

fun main() {
    val ss = Student2()
    // No
    // ss.grades.add(600)
    // ss.grades = listOf(10, 11, 12)

    println(ss.grades)

    ss.grades = listOf(1, 2, 5, 4) // OK
    ss.average
    println("$ss.grades, $ss.average")
    ss.grades = listOf(1, 2, 5, 8) // OK
    println(ss.grades)
    ss.grades += listOf(3, 4) // OK
    println(ss.grades)
}