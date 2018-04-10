package com.asura.design_patterns.principle.renting.step0

/**
 * 中介
 * @author Created by Asura on 2018/4/10 10:44.
 */
class Mediator() {
    var mRooms = arrayListOf<Room>()

    fun getAllRoom(): List<Room> {
        return mRooms
    }

    init {
        for (i in 0 until 5) {
            mRooms.add(Room((14 + i).toFloat(), ((14 + i) * 150).toFloat()))
        }
    }
}