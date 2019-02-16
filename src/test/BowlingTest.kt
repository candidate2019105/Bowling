package test

import main.bowling.BowlingGame
import org.junit.Test
import kotlin.test.assertNotNull

class BowlingTest {

    @Test
    fun assertBowlingGameExists() {
        assertNotNull(BowlingGame())
    }
}
