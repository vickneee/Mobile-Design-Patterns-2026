import kotlin.math.sqrt

data class Vector2DInt1(val x: Int = 0, val y: Int = 0) {
    fun dot(other: Vector2DInt1): Int = this.x * other.x + this.y * other.y
    fun length() = sqrt(dot(this).toDouble())
}

fun main() {
    
}