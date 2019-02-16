package main.kotlin.bowlingGame.model

open class Frame(var rolls : List<Roll> = mutableListOf()) {
    fun score(nextFrame: Frame) : Int {
        return -1
    }
}