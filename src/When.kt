fun main() {
    val trafficLightColor = "Amber"

    when (trafficLightColor) {
        "Red" -> println("Stop")
        "Yellow", "Amber" -> println("Slow")
        "Green" -> println("Go")
        else -> println("Invalid traffic-light color")
    }

    val trafficLightColor1 = "Black"

    val message =
        if (trafficLightColor1 == "Red") "Stop"
        else if (trafficLightColor1 == "Yellow") "Slow"
        else if (trafficLightColor1 == "Green") "Go"
        else "Invalid traffic-light color"

    println(message)

    val trafficLightColor2 = "Amber"

    val message2 = when(trafficLightColor2) {
        "Red" -> "Stop"
        "Yellow", "Amber" -> "Slow"
        "Green" -> "Go"
        else -> "Invalid traffic-light color"
    }
    println(message2)

    val x1 = 7

    when (x1) {
        2, 3, 5, 7 -> println("$x1 is a prime number between 1 and 10.")
        else -> println("$x1 isn't a prime number between 1 and 10.")
    }

    val x: Any = 4

    when (x) {
        2, 3, 5, 7 -> println("$x is a prime number between 1 and 10.")
        in 1..10 -> println("x is a number between 1 and 10, but not a prime number.")
        is Int -> println("x is an integer number, but not between 1 and 10.")
        else -> println("x isn't an integer number.")
    }
}