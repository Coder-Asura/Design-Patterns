package com.asura.design_patterns.strategy.step0

import com.asura.design_patterns.ALog

/**
 * 公交车价格计算策略
 *
 * @author Created by Asura on 2018/4/13 15:08.
 */
class BusStrategy : CalculateStrategy {
    /**
     * 实现具体的价格计算方法
     */
    override fun calculatePrice(km: Int): Float {
        //具体的计算方式忽略，直接简化为 2 元
        ALog.d("坐公交车需要花费 2 元")
        return 2f
    }
}