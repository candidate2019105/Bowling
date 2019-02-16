package main.kotlin.bowlingGame.uils

import main.kotlin.bowlingGame.model.Frame

class BowlingUtils {
    companion object {
        fun isSpare(element: Frame): Boolean {
            return element.rolls.size == 2 && element.score() == 10
        }

        fun isStrike(element: Frame): Boolean {
            return element.rolls.size == 1 && element.score() == 10
        }

        fun spareBonus(playedFrames: List<Frame>, index: Int): Int {
            return  playedFrames[index + 1].rolls[0].pins
        }

        fun strikeBonus(playedFrames: List<Frame>, index: Int): Int {
            return BowlingUtils.getTwoRollValue(playedFrames, index)
        }

        private fun getTwoRollValue(playedFrames: List<Frame>, index: Int): Int {
            val nextFrame = playedFrames[index + 1]
            return if (nextFrame.rolls.size == 2) {
                nextFrame.score()
            } else {
                nextFrame.score() + playedFrames[index + 2].rolls[0].pins
            }
        }
    }
}
