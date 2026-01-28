package org.example

class Major(val name: String) {

    private val students: MutableList<Student> = mutableListOf<Student>()

    fun addStudent(student: Student) {
        students.add(student)
    }

    // Overall stats using students weighted averages
    fun stats(): Triple<Double, Double, Double> {
        val averages = students.map { it.weightedAverage() }

        return Triple(
            averages.minOrNull() ?: 0.0,
            averages.maxOrNull() ?: 0.0,
            averages.average()
        )
    }

    // Stats for a specific course
    fun stats(courseName: String): Triple<Double, Double, Double> {
        val averages = students.mapNotNull { student ->
            val courseGrades = student.coursesByName(courseName)
            if (courseGrades.isEmpty()) null
            else courseGrades.sumOf { it.grade * it.credits } / courseGrades.sumOf { it.credits }
        }
        return Triple(
            averages.minOrNull() ?: 0.0,
            averages.maxOrNull() ?: 0.0,
            averages.average()
        )
    }
}