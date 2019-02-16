package main.kotlin.bowlingGame.uils

import main.kotlin.bowlingGame.model.Frame

class BowlingUtils {
    companion object {
        fun isSpare(element: Frame): Boolean {
            return element.rolls.size == 2 && element.score() == 10
        }

        fun getNextRollValue(playedFrames: List<Frame>, index: Int): Int {
            return if (playedFrames.size == index - 1) {
                0
            } else {
                playedFrames[index + 1].rolls[0].pins
            }
        }
    }
}
