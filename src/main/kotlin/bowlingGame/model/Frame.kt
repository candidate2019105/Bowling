package main.kotlin.bowlingGame.model

import Parameters.Companion.MAX_PIN_NUMBER

open class Frame {
    val rolls = mutableListOf<Roll>()

    fun score() : Int {
        var score = 0
        for(roll in rolls) {
            score += roll.pins
        }
        return score
    }

    fun mayRollAgain(): Boolean {
        return rolls.size < 2 && rolls[0].pins != 10
    }

    fun roll(i: Int) {
        when {
            rolls.size == 0 -> addWithinBoundaries(0, i)
            else -> addWithinBoundaries(rolls[0].pins, i)
        }

    }

    private fun addWithinBoundaries(lastRoll: Int, newRoll: Int) {
        val max = MAX_PIN_NUMBER - lastRoll
        val pinsDown = if (newRoll > max) max else newRoll
        rolls.add(Roll(pinsDown))
    }
}