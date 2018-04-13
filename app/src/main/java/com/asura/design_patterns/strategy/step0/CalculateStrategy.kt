package com.asura.design_patterns.strategy.step0

/**
 * 定义一个计价器策略接口
 *
 * @author Created by Asura on 2018/4/13 15:06.
 */
interface CalculateStrategy {
    /***
     * 计算价格
     */
    fun calculatePrice(km: Int): Float
}