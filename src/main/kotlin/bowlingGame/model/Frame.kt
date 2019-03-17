package bowlingGame.model

import Parameters.Companion.DEFAULT_BASE_SCORE
import Parameters.Companion.MAX_PIN_NUMBER
import Parameters.Companion.MAX_ROLL_PER_FRAME

open class Frame {
    val rolls = mutableListOf<Roll>()

    fun computeScore() : Int {
        var score = DEFAULT_BASE_SCORE
        for(roll in rolls) {
            score += roll.pins
        }
        return score
    }

    fun mayRollAgain(): Boolean {
        return rolls.size < MAX_ROLL_PER_FRAME && rolls[0].pins != MAX_PIN_NUMBER
    }

    fun roll(pinsHit: Int) {
        when {
            rolls.size == 0 -> addWithinBoundaries(0, pinsHit)
            else -> addWithinBoundaries(rolls[0].pins, pinsHit)
        }

    }

    private fun addWithinBoundaries(lastRoll: Int, newRoll: Int) {
        val max = MAX_PIN_NUMBER - lastRoll
        val pinsDown = if (newRoll > max) max else newRoll
        rolls.add(Roll(pinsDown))
    }
}