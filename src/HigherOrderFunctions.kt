class Cookie(
    val name: String,
    val softBaked: Boolean,
    val hasFilling: Boolean,
    val price: Double
)

val cookies = listOf(
    Cookie(
        name = "Chocolate Chip",
        softBaked = false,
        hasFilling = false,
        price = 1.69
    ),
    Cookie(
        name = "Banana Walnut",
        softBaked = true,
        hasFilling = false,
        price = 1.49
    ),
    Cookie(
        name = "Vanilla Creme",
        softBaked = false,
        hasFilling = true,
        price = 1.59
    ),
    Cookie(
        name = "Chocolate Peanut Butter",
        softBaked = false,
        hasFilling = true,
        price = 1.49
    ),
    Cookie(
        name = "Snickerdoodle",
        softBaked = true,
        hasFilling = false,
        price = 1.39
    ),
    Cookie(
        name = "Blueberry Tart",
        softBaked = true,
        hasFilling = true,
        price = 1.79
    ),
    Cookie(
        name = "Sugar and Sprinkles",
        softBaked = false,
        hasFilling = false,
        price = 1.39
    )
)

fun main() {

    // ForEach - Iteration
    cookies.forEach { println( "Menu item: ${it.name}") }

    // Print name and price
    // Map will create a new list with the results of the transformation
    // ALL the time same size as the original list
    val fullMenu = cookies.map {
        "${it.name} - $${it.price}"
    }

    println("Full Menu: ")
    fullMenu.forEach { println(it) }

    // FILTER will create a new list with only the items that match the condition
    // Filter list will be smaller than the original list

    val softBakedMenu = cookies.filter { it.softBaked }

    println("Soft Baked Menu: ")
    softBakedMenu.forEach { println("${it.name} - ${it.price}") }

    // Like map() and forEach(), filter() takes a single lambda expression as a parameter.
    //GROUP BY - will create a map of lists based on the condition

    println("Grouped Menu: ")

    // GROUP
    val groupedMenu = cookies.groupBy { it.softBaked }

    // SEPARATE THE GROUPS
    val groupedSoftBakedMenu = groupedMenu[true] ?: listOf() // If there are no soft-baked cookies, return an empty list

    val groupedCrunchyMenu = groupedMenu[false] ?: listOf()

    println("Soft cookies:")
    groupedSoftBakedMenu.forEach {
        println("${it.name} - $${it.price}")
    }
    println("Crunchy cookies:")
    groupedCrunchyMenu.forEach {
        println("${it.name} - $${it.price}")
    }

    // FOLD, An initial value.
    // The fold() function is used to generate a single value from a collection.


}