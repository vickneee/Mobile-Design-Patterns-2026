package org.example

class Student(name: String, age: Int) : Human(name, age) {

    private val courseList = mutableListOf<CourseRecord>()

    val courses: List<CourseRecord>
        get() = courseList.toList()

    fun addCourse(course: CourseRecord) {
        courseList.add(course)
    }
}