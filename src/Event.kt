enum class DayPart {
    MORNING, AFTERNOON, EVENING;
}

data class Event(val title: String, val description: String? = null, val dayPart: DayPart, val durationInMinutes: Int) {
}

// Extension property to determine if an event is short or long based on its duration
val Event.durationOfEvent: String
    get() = if (this.durationInMinutes < 60) "Short" else "Long"

fun main() {

    val event1 = Event(title = "Wake up", description = "Time to get up", dayPart = DayPart.MORNING, durationInMinutes = 0)
    val event2 = Event(title = "Eat breakfast", dayPart = DayPart.MORNING, durationInMinutes = 15)
    val event3 = Event(title = "Learn about Kotlin", dayPart = DayPart.AFTERNOON, durationInMinutes = 30)
    val event4 = Event(title = "Practice Compose", dayPart = DayPart.AFTERNOON, durationInMinutes = 60)
    val event5 = Event(title = "Watch latest DevBytes video", dayPart = DayPart.AFTERNOON, durationInMinutes = 10)
    val event6 = Event(title = "Check out latest Android Jetpack library", dayPart = DayPart.EVENING, durationInMinutes = 45)

    val events = mutableListOf<Event>(event1, event2, event3, event4, event5, event6)

    println("Events for the day:")
    for (event in events) {
        println("- ${event.title} (${event.dayPart}, ${event.durationInMinutes} minutes long)")
    }

    val shortEvents = events.filter { it.durationInMinutes < 60 }
    println("You have ${shortEvents.size} short events today.")

    val groupedEvents = events.groupBy { it.dayPart }
    groupedEvents.forEach { (dayPart, events) ->
        println("$dayPart: ${events.size} events")
    }

    println("Last event of the day: ${events.last().title}")

    println("Duration of first event of the day: ${events[0].durationOfEvent}")
    println("Duration of third event of the day: ${events[4].durationOfEvent}")
    println("Duration of fourth event of the day: ${events[3].durationOfEvent}")
}

