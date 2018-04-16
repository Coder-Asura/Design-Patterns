package com.asura.design_patterns.iterator.step2

import com.asura.design_patterns.ALog

/**
 * @author Created by Asura on 2018/4/16 18:29.
 */
abstract class Leader {
    public var nextHandler: Leader? = null
    protected abstract fun limit(): Int
    protected abstract fun handle(money: Int)

    public fun handleRequest(money: Int) {
        if (money <= limit()) {
            handle(money)
        } else {
            if (nextHandler != null) {
                nextHandler!!.handleRequest(money)
            } else {
                ALog.d("没谁能报销了，自掏腰包")
            }
        }
    }
}