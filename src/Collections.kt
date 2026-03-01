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


}