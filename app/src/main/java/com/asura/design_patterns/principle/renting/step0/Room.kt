package com.asura.design_patterns.principle.renting.step0

/**
 * 房间
 * @author Created by Asura on 2018/4/10 10:32.
 */
class Room(var area: Float, var price: Float) {
    override fun toString(): String {
        return "Room(area=$area, price=$price)"
    }
}