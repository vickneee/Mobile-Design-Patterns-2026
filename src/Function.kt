fun main() {
    // val greeting = birthdayGreeting()
    println(birthdayGreeting(age = 7))
    println(birthdayGreeting(age = 2, name ="Rex"))
    println(birthdayGreeting("Annika", 20))
}

fun birthdayGreeting(name: String = "Rover", age: Int): String {
    val nameGreeting = "Happy Birthday, $name!"
    val ageGreeting = "You are now $age years old!"
    return "$nameGreeting\n$ageGreeting"
}

