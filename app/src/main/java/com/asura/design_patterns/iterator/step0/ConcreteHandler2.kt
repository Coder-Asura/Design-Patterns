package com.asura.design_patterns.iterator.step0

import com.asura.design_patterns.ALog

/**
 * 具体的处理者
 *
 * @author Created by Asura on 2018/4/16 17:39.
 */
class ConcreteHandler2 : Handler() {

    override fun handleRequest(condition: String) {
        if (condition.equals("ConcreteHandler2")) {
            ALog.d("ConcreteHandler2 handled")
        } else {
            successor!!.handleRequest(condition)
        }
    }
}