//abstract class Shape {
//    abstract val area: Double
//    abstract val square: Double
//}

sealed interface Shape {
    val area: Double
}

data class Rectangle(val w: Double, val h: Double) : Shape {
    override val area: Double
    get() = w * h
}

data class Circle(val radius: Double) : Shape {
    override val area : Double
    get() = radius * radius
}

fun printShapes(vararg shapes: Shape) {
    for (shape in shapes) {
        val output = when (shape) {
            is Rectangle -> shape.area
            is Circle -> shape.area
        }
        println(output)
    }
}

class ABC(val a: Int, val b: Int, c: Int)  {
    val d = 2 * c
    val e
        get() =  d -6
}

fun main() {

    val r = Rectangle(1.0, 2.0)
    println(r.area)

    val c = Circle(1.0)
    println(c.area)

    printShapes(r, c)
}