class SmartDevice(val name: String = "Android TV", val category: String = "Entertainment") {

    var deviceStatus = "online"

    init {
        println("SmartDevice is created")
    }

    var speakerVolume = 2
        get() = field
        set(value) {
            if (value in 0..100) {
                field = value
            }
        }


    fun turnOn() {
        println("Smart device is turned on.")
    }

    fun turnOff() {
        println("Smart device is turned off.")
    }
}

fun main() {
    val smartTvDevice = SmartDevice()
    smartTvDevice.turnOn()
    smartTvDevice.turnOff()
}
