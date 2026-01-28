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
        // Students who have taken the course
        val participants = students.filter { it.coursesByName(courseName).isNotEmpty() }

        val minAvg = participants.minOfOrNull { it.weightedAverage() } ?: 0.0
        val maxAvg = participants.maxOfOrNull { it.weightedAverage() } ?: 0.0

        val courseRecords = participants.flatMap { it.coursesByName(courseName) }
        val courseAverage = if (courseRecords.isEmpty()) 0.0 else courseRecords.map { it.grade }.average()

        return Triple(minAvg, maxAvg, courseAverage)
    }
}