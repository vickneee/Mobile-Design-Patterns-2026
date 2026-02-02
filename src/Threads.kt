import java.util.concurrent.CountDownLatch
import kotlin.concurrent.thread

fun main() {
    println("Program start")
    var counter = 0
    val latch = CountDownLatch(100_000)
    for (i in 1..100_000) {
        thread {
            counter++
            latch.countDown()
        }
    }
    latch.await()
    println("Counter $counter ms")
}