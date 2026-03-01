class Collections {
}

fun main() {
    val rockPlanets = arrayOf("Mercury", "Venus", "Earth", "Mars")

    val gasPlanets = arrayOf("Jupiter", "Saturn", "Uranus", "Neptune")

    val solarSystem = rockPlanets + gasPlanets
    println(solarSystem[0])
    println(solarSystem[1])
    println(solarSystem[2])
    solarSystem[3] = "Little Earth"
    println(solarSystem[3])
    println(solarSystem[4])
    println(solarSystem[5])
    println(solarSystem[6])

    // solarSystem[8] = "Pluto" // Error

    val newSolarSystem = arrayOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune", "Pluto")

    println(newSolarSystem[8])

    val solarSystemList = listOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")

    println(solarSystemList.size)

    println(solarSystemList[2])
    println(solarSystemList.get(3))
    println(solarSystemList[4])
    println(solarSystemList.indexOf("Earth"))

    for (planet in solarSystemList) {
        println(planet)
    }

    val solarSystem2 = mutableListOf("Mercury", "Venus", "Earth", "Mars")

    solarSystem2.add("Pluto")
    solarSystem2.remove("Venus")
    solarSystem2.add(3, "Jupiter")

    for (planet in solarSystem2) {
        println(planet)
    }

    solarSystem2.removeAt(2)

    for (planet in solarSystem2) {
        println(planet)
    }

    println("Future Moon" in solarSystem)

    println(solarSystem.contains("Pluto"))

    val solarSystemSet = mutableSetOf<String>("Mercury", "Venus", "Earth", "Mars")

    println(solarSystemSet.size)
    solarSystemSet.add("Pluto")

    println(solarSystemSet.size)
    println(solarSystemSet.contains("Pluto"))

    solarSystemSet.remove("Pluto")

    println(solarSystemSet.size)
    println(solarSystemSet.contains("Pluto"))

    val mutableMapExample = mutableMapOf<String, Int>("Mercury" to 0,
        "Venus" to 0,
        "Earth" to 1,
        "Mars" to 2,
        "Jupiter" to 79,
        "Saturn" to 82,
        "Uranus" to 27,
        "Neptune" to 14)

    println(mutableMapExample.size)

    mutableMapExample["Mercury"] = 0

    println(mutableMapExample.size)

    println(mutableMapExample["Mercury"])

    println(mutableMapExample.get("Theia"))

    println(mutableMapExample.remove("Mars"))

    println(mutableMapExample.size)

    mutableMapExample["Jupiter"] = 78
    println(mutableMapExample["Jupiter"])
    println(mutableMapExample.values.toList())

}