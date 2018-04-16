package com.asura.design_patterns.iterator.step0

import com.asura.design_patterns.ALog

/**
 * 具体的处理者
 *
 * @author Created by Asura on 2018/4/16 17:39.
 */
class ConcreteHandler1 : Handler() {

    override fun handleRequest(condition: String) {
        if (condition.equals("ConcreteHandler1")) {
            ALog.d("ConcreteHandler1 handled")
        } else {
            successor!!.handleRequest(condition)
        }
    }
}