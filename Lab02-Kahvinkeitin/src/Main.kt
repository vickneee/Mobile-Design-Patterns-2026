// Luokkamäärittely:
class Kahvinkeitin(val maxVesi: Int = 300, val maxKahvi: Int = 100) {

    var isOn: Boolean = false
        private set
    var vesi: Int = 0
        private set
    var kahvi: Int = 0
        private set

    // Computed property = laskettu ominaisuus, sille ei varata omaa muistipaikkaa
    // Arvo lasketaan joka kerta, kun sitä kysytään
    val espressoja: Int
        // Limit is smaller number, Veden tai kahvin perustella lasketaan arvo (pienempi arvo merkitse)
        get() = minOf(vesi / 30, kahvi / 16)
    // Computed property = laskettu ominaisuus, sille ei varata omaa muistipaikkaa
    // Arvo lasketaan joka kerta, kun sitä kysytään
    val tavallisia: Int
        // Limit is smaller number, Veden tai kahvin perustella lasketaan arvo (pienempi arvo merkitse)
        get() = minOf(vesi / 200, kahvi / 15)

    fun taytaVesiSailio(): Int {
        if (vesi < maxVesi) {
            vesi = 300
        }
        return vesi
    }

    fun taytaKahviSailio():Int {
        if (kahvi < maxKahvi) {
            kahvi = maxKahvi
        }
        return kahvi
    }

    fun teeEspresso(): Boolean {
        return if (!isOn) {
            false
        } else {
            if (vesi > 30 && kahvi > 15) {
                vesi -= 30
                kahvi -= 16
                true
            } else {
                false
            }
        }
    }

    fun teeTavallinenKahvi(): Boolean {
        return if (!isOn) {
            false
        } else {
            if (vesi > 30 && kahvi > 15) {
                vesi -= 200
                kahvi -= 15
                true
            } else {
                false
            }
        }
    }

    fun painaOnOffNappia() {
        isOn = !isOn
    }

    override
    fun toString(): String {
        return "Keitin: $vesi/300 vettä, $kahvi/100 ${if (isOn) "kahvia on päällä" else "kahvia on kiinni"}"
    }
}

// Pääohjelma:
fun main() {
    val k = Kahvinkeitin()
    println(k)
    k.taytaVesiSailio()
    k.taytaKahviSailio()
    println("$k")
    println("espressoja: ${k.espressoja}")
    println("tavallisia: ${k.tavallisia}")
    println("tee espresso: ${k.teeEspresso()}")
    println(k)
    k.painaOnOffNappia()
    println("tee tavallinen kahvi: ${k.teeTavallinenKahvi()}")
    println("$k")
    for (i in 0..4) {
        println("tee espresso: ${k.teeEspresso()}")
        println("$k")
    }
    println("espressoja: ${k.espressoja}")
    println("tavallisia: ${k.tavallisia}")
    k.taytaVesiSailio()
    println("$k")
    for (i in 0..4) {
        println("tee espresso: ${k.teeEspresso()}")
        println("$k")
    }
}

// Tuloste:
/*
Keitin: 0/300 vettä, 0/100 kahvia on kiinni
Keitin: 300/300 vettä, 100/100 kahvia on kiinni
espressoja: 6
tavallisia: 1
tee espresso: false
Keitin: 300/300 vettä, 100/100 kahvia on kiinni
tee tavallinen kahvi: true
Keitin: 100/300 vettä, 85/100 kahvia on päällä
tee espresso: true
Keitin: 70/300 vettä, 69/100 kahvia on päällä
tee espresso: true
Keitin: 40/300 vettä, 53/100 kahvia on päällä
tee espresso: true
Keitin: 10/300 vettä, 37/100 kahvia on päällä
tee espresso: false
Keitin: 10/300 vettä, 37/100 kahvia on päällä
tee espresso: false
Keitin: 10/300 vettä, 37/100 kahvia on päällä
espressoja: 0
tavallisia: 0
Keitin: 300/300 vettä, 37/100 kahvia on päällä
tee espresso: true
Keitin: 270/300 vettä, 21/100 kahvia on päällä
tee espresso: true
Keitin: 240/300 vettä, 5/100 kahvia on päällä
tee espresso: false
Keitin: 240/300 vettä, 5/100 kahvia on päällä
tee espresso: false
Keitin: 240/300 vettä, 5/100 kahvia on päällä
tee espresso: false
Keitin: 240/300 vettä, 5/100 kahvia on päällä
 */
