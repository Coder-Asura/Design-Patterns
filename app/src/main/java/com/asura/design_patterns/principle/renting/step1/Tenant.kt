package com.asura.design_patterns.principle.renting.step1

/**
 * 租户
 * @author Created by Asura on 2018/4/10 10:59.
 */
class Tenant(var roomArea: Float, var roomPrice: Float) {
    companion object {
        val diffArea: Float = 1f
        val diffPrice: Float = 100f
    }

    //只需要租户和中介打交道就好了
    fun rentRoom(mediator: Mediator) {
        mediator.rentOut(roomArea, roomPrice)
    }
}