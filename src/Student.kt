class Student {
    var grades = listOf<Int>()
        private set
    fun addGrade(g: Int) {
        // grades.add(100) not possible if grades is val and immutable list

        if (g in 1..5) {
            grades += g
        } else {
            println("Invalid grade: $g")
        }
    }
}

fun main() {
    val s = Student()
    s.addGrade(3)
    s.addGrade(5)
    s.addGrade(7)
    println(s.grades)

    // s.grades.add(600)
    // s.grades = listOf<Int>(0)
    println(s.grades)
}