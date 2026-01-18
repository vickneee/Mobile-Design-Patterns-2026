import java.lang.Math.random


fun main() {

    // Filter
    val spices = listOf("curry", "pepper", "cayenne", "ginger", "red curry", "green curry", "red pepper" )

    val results = spices.filter { it.contains("curry") }
    println(results)

    // Lambda
    val swim = { println("Swim") }
    swim()

    var dirty = 20

    val waterFilter = { dirty: Int -> dirty / 2 }
    val waterFilter1: (Int) -> Int = { dirty -> dirty / 3 }
    fun feedFish(dirty: Int) = dirty + 10

    fun updateDirty(dirty: Int, operation: (Int) -> Int ): Int {
        return operation(dirty)
    }

    fun dirtyProcessor() {
        dirty = updateDirty(dirty, waterFilter)
        dirty = updateDirty(dirty, ::feedFish)
        dirty = updateDirty(dirty, {
            dirty + 50
        })
    }
    waterFilter(dirty)
    waterFilter1(dirty)

    val random1 = random()
    val random2 = {random()}
    println(random1)
    println(random2)
}