// --- Data class for measurements ---
data class WeatherData(val temperature: Float, val humidity:
Float, val pressure: Float)

// --- The Observer interface ---
interface Observer {
    fun update(data: WeatherData)
}

// --- The Subject (or Observable) ---
// This class should be able to register, remove, and notify observers.
class WeatherStation {
    private var currentData: WeatherData? = null
    private val observers = mutableListOf<Observer>()

    fun registerObserver(observer: Observer) {
        observers.add(observer)
    }

    fun removeObserver(observer: Observer) {
        observers.remove(observer)
    }

    // This method is called whenever new weather data is available.
    fun measurementsChanged(newData: WeatherData) {
        this.currentData = newData
        println("WeatherStation: Got new data -> $currentData")
        notifyObservers()
    }

    private fun notifyObservers() {
        currentData?.let { data ->
            observers.forEach { it.update(data) }
        }
    }
}

// --- The Observers ---
// This class should update its display when it receives new data.
class CurrentConditionsDisplay : Observer {
    private var temperature: Float = 0f
    private var humidity: Float = 0f

    fun display() {
        println("CurrentConditionsDisplay: Current conditions: $temperature°C degrees and $humidity% humidity")
    }

    override fun update(data: WeatherData) {
        this.temperature = data.temperature
        this.humidity = data.humidity
        display()
    }
}
// This class should calculate and display the average temperature.
class StatisticsDisplay: Observer {
    private val temperatures = mutableListOf<Float>()

    fun display() {
        val avg = temperatures.average()
        println("StatisticsDisplay: Avg temperature: ${avg}C")
    }

    override fun update(data: WeatherData) {
        temperatures.add(data.temperature)
        display()
    }
}

// --- Main function to run the simulation ---
fun main() {
    // 1. Create the WeatherStation (the subject).
    val weatherStation = WeatherStation()

    // 2. Create the display devices (the observers).
    val currentConditionsDisplay = CurrentConditionsDisplay()
    val statisticsDisplay = StatisticsDisplay()

    // 3. Register the observers with the weather station.
    weatherStation.registerObserver(currentConditionsDisplay)
    weatherStation.registerObserver(statisticsDisplay)

    // Simulate new weather measurements.
    println("--- Simulating new measurement ---")
    weatherStation.measurementsChanged(WeatherData(25.0f, 65f,
        1012f))
    println("\n--- Simulating another measurement ---")
    weatherStation.measurementsChanged(WeatherData(27.5f, 70f,
        1011f))

    // 4. Unregister one of the observers.
    println("\n--- Unregistering Statistics Display ---")
    weatherStation.removeObserver(statisticsDisplay)

    // 5. Final measurement
    println("\n--- Simulating a final measurement ---")
    weatherStation.measurementsChanged(WeatherData(26.0f, 90f,
        1013f))
}

/*
--- Simulating new measurement ---
WeatherStation: Got new data -> WeatherData(temperature=25.0, humidity=65.0,
pressure=1012.0) CurrentConditionsDisplay: Current conditions: 25.0C degrees and 65.0%
humidity StatisticsDisplay: Avg temperature: 25.0C
--- Simulating another measurement ---
WeatherStation: Got new data -> WeatherData(temperature=27.5, humidity=70.0,
pressure=1011.0) CurrentConditionsDisplay: Current conditions: 27.5C degrees and 70.0%
humidity StatisticsDisplay: Avg temperature: 26.25C
--- Unregistering Statistics Display ---
--- Simulating a final measurement ---
WeatherStation: Got new data -> WeatherData(temperature=26.0, humidity=90.0,
pressure=1013.0) CurrentConditionsDisplay: Current conditions: 26.0C degrees and 90.0% humidity
*/

