package org.example

class Student(name: String, age: Int) : Human(name, age) {

    private val courses = mutableListOf<CourseRecord>()

    fun addCourse(course: CourseRecord) {
        courses.add(course)
    }

    fun weightedAverage(): Double {
        val totalCredits = courses.sumOf { it.credits }
        val weightedSum = courses.sumOf { it.grade * it.credits }
        val avg = if (totalCredits == 0) 0.0 else weightedSum / totalCredits
        return avg
    }

    fun minMaxGrades(): Pair<Double, Double> {
        val grades = courses.map { it.grade }
        return Pair(grades.minOrNull() ?: 0.0, grades.maxOrNull() ?: 0.0)
    }

    fun coursesByName(name: String): List<CourseRecord> {
        return courses.filter { it.name.equals(name, true) }
    }
}