class Student {
//    var grades = listOf<Int>()
//        private set

    private val _grades = mutableListOf<Int>()
    // Computed property
    val grades: List<Int>  // Read-only public property
        get() = _grades.toList() // Immutable list
//        set(list : List<Int>) {
//            val grades = _grades + _grades.addAll(list)
//        }

    fun addGrade(g: Int) {
        // grades.add(100) not possible if grades is val and immutable list

        if (g in 1..5) {
            _grades += g
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