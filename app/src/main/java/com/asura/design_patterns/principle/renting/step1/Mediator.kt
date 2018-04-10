package com.asura.design_patterns.principle.renting.step1

import android.util.Log

/**
 * 中介
 * @author Created by Asura on 2018/4/10 10:44.
 */
class Mediator() {
    var mRooms = arrayListOf<Room>()

    init {
        for (i in 0 until 5) {
            mRooms.add(Room((14 + i).toFloat(), ((14 + i) * 150).toFloat()))
        }
    }

    //中介负责根据租户条件筛选租出房间
    fun rentOut(area: Float, price: Float): Room? {
        for (room in mRooms) {
            if (isSuitable(area, price, room)) {
                Log.d("asura", "租到房子了: ${room}")
                return room
            }
        }
        return null
    }

    private fun isSuitable(area: Float, price: Float, room: Room): Boolean {
        return Math.abs(room.price - price) < Tenant.diffPrice
                && Math.abs(room.area - area) < Tenant.diffArea
    }
}