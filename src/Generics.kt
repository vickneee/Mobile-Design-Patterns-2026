enum class Difficulty {
    EASY, MEDIUM, HARD
}

/*
equals()
hashCode(): you'll see this method when working with certain collection types.
toString()
componentN(): component1(), component2(), etc.
copy()
*/

interface ProgressPrintable {
    val progressText: String
    fun printProgressBar()
}

data class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty
) {}

class Quiz : ProgressPrintable {
    val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
    val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
    val question3 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)

    fun printQuiz() {
        question1.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
        question2.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
        question3.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
    }

    // Declare objects as companion objects
    companion object StudentProgress {
        var total: Int = 10
        var answered: Int = 3
    }

    override val progressText: String
        get() = "$answered of $total answered"

    override fun printProgressBar() {
        repeat(Quiz.answered) { print("▓") }
        repeat(Quiz.total - Quiz.answered) { print("▒") }
        println()
        println(progressText)
    }
}

// Add an extension property outside the Quiz class declaration to return a String that shows the progress of
// the student in the quiz. The format of the String should be "x of y answered", where x is the number of
// questions answered and y is the total number of questions in the quiz. Use the properties declared in the
// StudentProgress object to get these values.

// val Quiz.StudentProgress.progressText: String
//    get() = "$answered of $total answered"

// Extension function to print the progress of the student in the quiz. This function should use the extension
// property you just created to get the progress text and print it to the console.
    /*
fun Quiz.StudentProgress.printProgressBar() {
    repeat(Quiz.answered) {
        print("█")
    }
    repeat(Quiz.total - Quiz.answered) {
        print("░")
    }
    println()
    println(Quiz.progressText)
}
*/


fun main() {
    /*
    val question1 = Question<String>("Quoth the raven ___", "nevermore", difficulty = Difficulty.MEDIUM)
    val question2 = Question<Boolean>("The sky is green. True or false", false, difficulty = Difficulty.EASY)
    val question3 = Question<Int>("How many days are there between full moons?", 28, difficulty = Difficulty.HARD)

    // Not print if not data class
    println(question1.toString())
    println(question2.toString())

    // Printing individual String, Boolean, Int, because they are implemented already
    println(question1.questionText)
    println(question1.answer)
    println(question1.difficulty)

    println(question2.questionText)
    println(question2.answer)
    println(question2.difficulty)

    println(question3.questionText)
    println(question3.answer)
    println(question3.difficulty)

    println("${StudentProgress.answered} of ${StudentProgress.total} answered.")
    */

    /*Update the call to println() to reference the properties with Quiz.answered and Quiz.total. Even though these
    properties are declared in the StudentProgress object, they can be accessed with dot notation using only the
    name of the Quiz class. */
    println("${Quiz.answered} of ${Quiz.total} answered.")

    // Call the extension property to print the progress of the student in the quiz.
    // Quiz.printProgressBar()

    // Rewrite extension functions using interfaces
    Quiz().printProgressBar()

    val quiz = Quiz()
    quiz.printQuiz()
}

// https://github.com/JetBrains/compose-multiplatform