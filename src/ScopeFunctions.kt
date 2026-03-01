// Scope functions allow you to concisely access properties and methods from a class without having
// to repeatedly access the variable name.

// Eliminate repetitive object references with scope functions

// Replace long object names using let()
// Let refer to an object in a lambda expression using the identifier it

// Call an object's methods without a variable using apply()

/*
val quiz = Quiz().apply {
}

val quiz = Quiz().apply {
    printQuiz()
}

// Call an object's methods without a variable using apply() and print the quiz details in the lambda expression
Quiz().apply {
    printQuiz()
}
 */

/*
LET IT GO! Return the result of the lambda expression using let() and print the quiz details in the lambda expression.
Not ideal for chaining multiple operations together, since it returns the result of the lambda expression, not the context object.
Quiz let {
    it.printQuiz()
    println("Quiz details: $it")
}

RUN THIS MACHINE! Run a block of code without an object reference using run() and print the quiz details in the lambda expression.
Not ideal for chaining multiple operations together, since it returns the result of the lambda expression, not the context object.
Quiz().run {
    printQuiz()
    println("Quiz details: $this")
}

APPLY THIS METHOD returns the context OBJECT. This is useful when you want to perform some operations on an object
and then return the modified object.
Perfect for chaining multiple operations together, since it returns the context object.

 val quiz = Quiz().apply {
    printQuiz()
    println("Quiz details: $this")

ALSO IT IS Returns OBJECT. Chaining! This is useful when you want to perform some operations on an object
and then return the modified object.

val numberList = mutableListOf<Double>()
numberList.also { println("Populating the list") }
    .apply {
        add(2.71)
        add(3.14)
        add(1.0)
    }
    .also { println("Sorting the list") }
    .sort()


 */

class ScopeFunctions {

    /*
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
    */

}