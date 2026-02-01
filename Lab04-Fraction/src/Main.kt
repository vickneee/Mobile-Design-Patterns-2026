/*
Victoria Vavulina
2419829
 */

data class Fraction(var numerator: Int, var denominator: Int, private val sign: Int = 1): Comparable<Fraction> {

    init {
        val g = gcd(numerator, denominator)
        this.numerator /= g
        this.denominator /= g
    }

    // Greatest common divisor
    private fun gcd(numerator: Int, denominator: Int): Int {
        var x = kotlin.math.abs(numerator)
        var y = kotlin.math.abs(denominator)

        while (y != 0) {
            val c = y
            y = x % y
            x = c
        }
        return x
    }

    // Simplify Fraction using the greatest common divisor function
    private fun simplify(): Fraction {
        val g = gcd(numerator, denominator)
        return Fraction(numerator / g, denominator / g, sign)
    }

    fun add(fraction: Fraction): Fraction {
        if (fraction.denominator == denominator) {
            val newNumerator = numerator + fraction.numerator
            val newDenominator = denominator
            return Fraction(newNumerator, newDenominator, sign)
        } else {
            val newNumerator = numerator * fraction.denominator + fraction.numerator * denominator * sign
            val newDenominator = denominator * fraction.denominator
            return Fraction(newNumerator, newDenominator, sign)
        }
    }

    fun mult(fraction: Fraction): Fraction {
        val newNumerator = numerator * fraction.numerator * sign
        val newDenominator = denominator * fraction.denominator
        return Fraction(newNumerator, newDenominator, sign)
    }

    fun div(fraction: Fraction): Fraction {
        val newNumerator = numerator * fraction.denominator * sign
        val newDenominator = denominator * fraction.numerator
        return Fraction(newNumerator, newDenominator, sign)
    }

    fun subtr(fraction: Fraction): Fraction {
        if (fraction.denominator == denominator) {
            val newNumerator = numerator - fraction.numerator
            val newDenominator = denominator
            return Fraction(newNumerator, newDenominator, sign)
        } else {
            val newNumerator = numerator * fraction.denominator - fraction.numerator * denominator * sign
            val newDenominator = denominator * fraction.denominator
            return Fraction(newNumerator, newDenominator, sign)
        }
    }

    operator fun unaryMinus(): Fraction {
        return Fraction(numerator, denominator, -sign)
    }

    operator fun plus(fraction: Fraction): Fraction {
        return add(fraction).simplify()
    }

    operator fun minus(fraction: Fraction): Fraction {
        return subtr(fraction).simplify()
    }

    operator fun times(fraction: Fraction): Fraction {
        return mult(fraction).simplify()
    }

    fun negate(): Fraction {
        return Fraction(numerator, denominator, -sign)
    }

    override fun compareTo(other: Fraction): Int {
        val firstNumerator = sign * numerator * other.denominator
        val secondNumerator = other.sign * other.numerator * denominator
        return when {
            firstNumerator > secondNumerator -> 1
            firstNumerator < secondNumerator -> -1
            else -> 0
        }
    }

    override fun toString(): String {
        return "${sign * numerator}/$denominator"
    }
}

// Pääohjelma:
fun main() {
    val a = Fraction(1,2,-1)
    println(a)
    println(a.add(Fraction(1,3)))
    println(a.mult(Fraction(5,2, -1)))
    println(a.div(Fraction(2,1)))
    println(-Fraction(1,6) + Fraction(1,2))
    println(Fraction(2,3) * Fraction(3,2))
    println(Fraction(1,2) > Fraction(2,3)) // Comparable interface function compareTo()
}

// Tulostus:
/*
-1/2
-1/6
5/4
1/4
1/3
1/1
false
 */