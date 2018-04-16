package com.asura.design_patterns.iterator.step2

import com.asura.design_patterns.ALog

/**
 * @author Created by Asura on 2018/4/16 18:35.
 */
class Boss : Leader() {
    override fun limit(): Int {
        return 20000
    }

    override fun handle(money: Int) {
        ALog.d("太好了，老板报销了 $money 元")
    }
}