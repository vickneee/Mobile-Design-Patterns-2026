open class SmartDevice(val name: String, val category: String) {

    var deviceStatus = "online"
        protected set

    open val deviceType = "Unknown"

    constructor(name: String, category: String, statusCode: Int) : this(name, category) {
        deviceStatus = when (statusCode) {
            0 -> "offline"
            1 -> "online"
            else -> "unknown"
        }
    }

    init {
        println("SmartDevice is created")
    }

    open fun turnOn() {
        println("Smart device is turned on.")
    }

    open fun turnOff() {
        println("Smart device is turned off.")
    }
}

// Smart TV IS-A smart device.
open class SmartTvDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {

    override val deviceType = "Smart TV"

    private var speakerVolume = 2
        set(value) {
            if (value in 0..100) {
                field = value
            }
        }

    private var channelNumber = 1
        set(value) {
            if (value in 0..200) {
                field = value
            }
        }

    fun increaseSpeakerVolume() {
        speakerVolume++
        println("Speaker volume increased to $speakerVolume.")
    }

    fun nextChannel() {
        channelNumber++
        println("Channel number increased to $channelNumber")
    }

    override
    fun turnOn() {
        deviceStatus = "on"
        println("$name is turned on. Speaker volume is set to $speakerVolume and channel number is " +
                "set to $channelNumber.")
    }

    override fun turnOff() {
        deviceStatus = "off"
        println("$name is turned off.")
    }
}

class SmartLightDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {

    override val deviceType = "Smart Light"

    private var brightnessLevel = 0
        set(value) {
            if (value in 0..100) {
                field = value
            }
        }

    fun increaseBrightness() {
        brightnessLevel++
        println("Brightness increased to $brightnessLevel.")
    }

    override fun turnOn() {
        deviceStatus = "on"
        brightnessLevel = 2
        println("$name turned on. The brigtness level is $brightnessLevel.")
    }

    override fun turnOff() {
        deviceStatus = "off"
        brightnessLevel = 0
        println("$name turned off.")
    }
}

// The SmartHome class HAS-A smart TV device.
class SmartHome(
    val smartTvDevice: SmartTvDevice,
    val smartLightDevice: SmartLightDevice) {

    var deviceTurnObCount = 0
        private set

    fun turnOnTv() {
        smartTvDevice.turnOn()
    }

    fun turnOffTv() {
        smartTvDevice.turnOff()
    }

    fun turnNextChannel() {
        smartTvDevice.nextChannel()
    }

    fun increaseTvVolume() {
        smartTvDevice.increaseSpeakerVolume()
    }

    fun increaseLightBrightness() {
        smartLightDevice.increaseBrightness()
    }

    fun turnOffLight() {
        smartLightDevice.turnOff()
    }

    fun turnOffAllDevices() {
        turnOffTv()
        turnOffLight()
    }
}

fun main() {
    val smartDevice: SmartDevice = SmartTvDevice("Android TV", "Entertainment")
    smartDevice.turnOn()

    val smartTvDevice: SmartTvDevice = SmartTvDevice("SmartTV", "Entertainment")
    smartTvDevice.turnOn()
    smartTvDevice.nextChannel()
    smartTvDevice.turnOff()
}
