package bowlingGame.uils

import Parameters.Companion.MAX_PIN_NUMBER
import Parameters.Companion.MAX_ROLL_PER_FRAME
import bowlingGame.model.Frame

class BowlingUtils {
    companion object {
        fun isSpare(element: Frame): Boolean {
            return element.rolls.size == MAX_ROLL_PER_FRAME && element.score() == MAX_PIN_NUMBER
        }

        fun isStrike(element: Frame): Boolean {
            return element.rolls.size == 1 && element.score() == MAX_PIN_NUMBER
        }

        fun spareBonus(playedFrames: List<Frame>, index: Int): Int {
            return  playedFrames[index + 1].rolls[0].pins
        }

        fun strikeBonus(playedFrames: List<Frame>, index: Int): Int {
            return getTwoRollValue(playedFrames, index)
        }

        private fun getTwoRollValue(playedFrames: List<Frame>, index: Int): Int {
            val nextFrame = playedFrames[index + 1]
            return if (nextFrame.rolls.size == MAX_ROLL_PER_FRAME) {
                nextFrame.score()
            } else {
                nextFrame.score() + playedFrames[index + MAX_ROLL_PER_FRAME].rolls[0].pins
            }
        }
    }
}
