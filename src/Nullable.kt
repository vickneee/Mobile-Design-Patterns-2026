fun main() {
    var favoriteActor: String? = "Sandra Oh"
    println(favoriteActor)

    favoriteActor = null
    println(favoriteActor)

    var number: Int? = 10
    println(number)

    number = null
    println(number)

    // Nullable types have some special properties. For example,
    // you can’t call a method on a nullable type without checking for null first:
    val favoriteActorString: String? = null
    println(favoriteActorString?.length)

    val favoriteActor2: String? = "Sandra Oh"
    println(favoriteActor2!!.length) // You get a NullPointerException error:


    // To avoid this, you can use the safe call operator (?.)
    // to safely access the length property of a nullable string:
    val favoriteActor3: String? = "Sandra Oh"

    val lengthOfName = if (favoriteActor3 != null) {
        favoriteActor3.length
    } else {
        0
    }

    println("The number of characters in your favorite actor's name is $lengthOfName.")

    // Elvis operator (?:) can be used to provide a default value when the nullable type is null:
    val favoriteActor4: String? = "Marko Oh"

    val lengthOfName2 = favoriteActor4?.length ?: 0

    println("The number of characters in your favorite actor's name is $lengthOfName2.")
}
