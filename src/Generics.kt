
class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: String
)

fun main() {
        val question1 = Question<String>("Quoth the raven ___", "nevermore", "medium")
        val question2 = Question<Boolean>("The sky is green. True or false", false, "easy")
        val question3 = Question<Int>("How many days are there between full moons?", 28, "hard")

        println(question1.questionText)
        println(question1.answer)
        println(question1.difficulty)

        println(question2.questionText)
        println(question2.answer)
        println(question2.difficulty)

        println(question3.questionText)
        println(question3.answer)
        println(question3.difficulty)

}