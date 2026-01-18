import kotlin.math.*

open class TV (val channelCount: Int = 10, val maxVolume: Int = 20) {

    var isOn: Boolean = false
        private set
    var channel = 0
        set(value) {
            if (isOn && value in 0..channelCount)
                field = value
        }

    var volume = 0
        set(value) {
            if (isOn && value in 0..maxVolume) {
                field = value
            }
        }

    var volumePercent: Double
        get() = 100 * volume.toDouble() / maxVolume
        set(value) {
            val volumeLevel = round(value * maxVolume.toDouble() / 100)
            volume = volumeLevel.toInt()
        }

    fun turnedOnOff() { isOn = !isOn }

    override
    fun toString(): String {
        return "TV, ${ if (isOn) "isOn" else "isOff"}, Channel - $channel / $channelCount, Volume - $volume / $maxVolume"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is TV) return false

        return this.channel == other.channel && this.volume == other.volume && this.isOn == other.isOn
    }

    override fun hashCode(): Int {
        var result = channel.hashCode()
        result = 31 * result + isOn.hashCode()
        result = 31 * result + volume
        return result
    }
}

class SuperTV: TV() {

    private var muteVol = volume
    var muted: Boolean = false

    fun mute() {
        if (muted) {
            volume = muteVol
            muted = false
        }
        else {
            muteVol = volume
            volume = 0
            muted = true
        }
    }

    fun channelPlus() {

    }

    fun channelMinus() {

    }

    fun volumeUp() {

    }

    fun volumeDown() {}

    override
    fun toString(): String {
        return "SuperTV, ${ if (isOn) "isOn" else "isOff"}, Channel - $channel / $channelCount, Volume - $volume / $maxVolume"
    }
}

fun main () {
    val t = TV()
    val v = TV(20, 400)

    val superT = SuperTV()

    superT.mute()

    println(superT)

    t.turnedOnOff()
    t.channel = 3
    t.volume = 15
    println(t)
    println(v)

    t.volumePercent = 80.0
    println(t)
}