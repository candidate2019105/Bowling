/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package bowlingGame

import Parameters.Companion.DEFAULT_BASE_SCORE
import Parameters.Companion.MAX_PIN_NUMBER
import Parameters.Companion.MAX_ROUNDS
import bowlingGame.model.BonusFrame
import bowlingGame.model.Frame
import bowlingGame.uils.BowlingUtils
import bowlingGame.uils.BowlingUtils.Companion.spareBonus
import bowlingGame.uils.BowlingUtils.Companion.strikeBonus

class BowlingGame {
    var playedFrames = mutableListOf<Frame>()

    fun roll(pinsHit: Int) {
        if (playedFrames.isNotEmpty() &&
                playedFrames.last().mayRollAgain()) {
            playedFrames.last().roll(pinsHit)
        } else {
            val frame = if (playedFrames.size >= MAX_ROUNDS) BonusFrame() else Frame()
            frame.roll(pinsHit)
            playedFrames.add(frame)
        }
    }

    fun computeScore(): Int? {
        var score = DEFAULT_BASE_SCORE

        for ((index, element) in playedFrames.withIndex()) {
            if (element is BonusFrame) break

            score += when {
                BowlingUtils.isStrike(element) -> MAX_PIN_NUMBER + strikeBonus(playedFrames, index)
                BowlingUtils.isSpare(element) -> MAX_PIN_NUMBER + spareBonus(playedFrames, index)
                else -> element.computeScore()
            }
        }

        return score
    }
}

fun main(args: Array<String>) {
    val game = BowlingGame()

    for (element in args) {
        when (element) {
            "-" -> game.roll(MAX_PIN_NUMBER - game.playedFrames.last().computeScore())
            "x" -> game.roll(MAX_PIN_NUMBER)
            else -> element.toIntOrNull()?.let { game.roll(it) }
        }
    }

    println("Your computeScore is : ${game.computeScore()}")
}
