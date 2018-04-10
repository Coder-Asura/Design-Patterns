package com.asura.design_patterns.principle.renting.step0

import android.util.Log

/**
 * 租户
 * @author Created by Asura on 2018/4/10 10:59.
 */
class Tenant(var roomArea: Float, var roomPrice: Float) {
    companion object {
        val diffArea: Float = 1f
        val diffPrice: Float = 100f
    }
    //这里租户和房间的耦合较高，租户又有中介耦合
    //只需要租户和中介打交道就好了
    fun rentRoom(mediator: Mediator) {
        val rooms = mediator.getAllRoom()
        for (room in rooms) {
            if (isSuitable(room)) {
                Log.d("asura", "租到房子了: ${room}")
                break
            }
        }
    }

    private fun isSuitable(room: Room): Boolean {
        return Math.abs(room.price - roomPrice) < diffPrice
                && Math.abs(room.area - roomArea) < diffArea
    }
}