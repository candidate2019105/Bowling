/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package main.kotlin.bowlingGame

class BowlingGame {
    var score = 0

    fun roll(i: Int) {
        score += i
    }

    fun start() {

    }

    fun score(): Int? {
        return score
    }

}

fun main(args: Array<String>) {
    BowlingGame().start()
}
