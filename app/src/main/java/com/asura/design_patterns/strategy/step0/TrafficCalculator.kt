package com.asura.design_patterns.strategy.step0

/**
 * 交通费计算器
 *
 * @author Created by Asura on 2018/4/13 15:13.
 */
class TrafficCalculator(val strategy: CalculateStrategy) {
    fun calculatePrice(km: Int) {
        strategy.calculatePrice(km)
    }
}