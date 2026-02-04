
fun String.neeExtensionFunction(): String {
    val changeCaseTest: String = this.filter { it.isUpperCase() }
    return changeCaseTest
}

fun extensionExample(string: String): String {
    return string.neeExtensionFunction()
}

fun main() {
    extensionExample("hello")
}
