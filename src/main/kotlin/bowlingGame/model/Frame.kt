package main.kotlin.bowlingGame.model

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
        return rolls.size < 2
    }

    fun roll(i: Int) {
        rolls.add(Roll(i))
    }
}