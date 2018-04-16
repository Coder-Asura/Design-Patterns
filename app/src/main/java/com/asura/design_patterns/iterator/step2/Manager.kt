package com.asura.design_patterns.iterator.step2

import com.asura.design_patterns.ALog

/**
 * @author Created by Asura on 2018/4/16 18:33.
 */
class Manager : Leader() {
    override fun limit(): Int {
        return 5000
    }

    override fun handle(money: Int) {
        ALog.d("太好了，经理报销了 $money 元")
    }
}