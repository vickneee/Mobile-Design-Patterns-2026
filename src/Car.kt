import kotlin.math.max
import kotlin.math.min

data class Car(val maxSpeed: Double = 120.0, val gasolineCapacity: Double = 50.0) {

    var gasolineLevel: Double = 0.0
        private set
    var speed: Double = 0.0
        private set

    fun fillTank() {
        gasolineLevel = gasolineCapacity
    }

    fun accelerate() {
        val newSpeed = min(speed + 1.0, maxSpeed)
        val gasolineNeeded = (newSpeed - speed) * 0.1
        if(gasolineLevel >= gasolineNeeded) {
            gasolineLevel -= gasolineNeeded
            speed = newSpeed
        }
    }

    fun decelerate() {
        speed = max(speed - 1.5, 0.0)
    }
}

fun main() {
    val car = Car()

    val resultRun = car.run {
        fillTank()
        accelerate()
        decelerate()
        while (gasolineLevel < gasolineCapacity) {
            fillTank()
        }
        "Gasoline: $gasolineLevel"
    }
    println(resultRun)

    val resultApply = car.apply {
        fillTank()
        accelerate()
        decelerate()
        "Gasoline: $gasolineLevel"
    }
    println("Car Apply: $resultApply")


    val resultLet = car.let {
        it.fillTank()
        "Let: $it"
    }
    println("Let: $resultLet")

    val resultAlso = car.also {
        it.fillTank()
        "Also: $it"
    }
    println("Also: $resultAlso")

}