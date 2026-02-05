abstract class Shape {
    abstract val area: Double
    abstract val square: Double
}

interface Shaape {
    val area: Double
}

data class Rectangle(val w: Double, val h: Double) : Shape() {

    override val area: Double
    get() = w * h

    override val square: Double
    get() = w * h
}

fun main() {

    val r = Rectangle(1.0, 2.0)
    println(r.square)
}