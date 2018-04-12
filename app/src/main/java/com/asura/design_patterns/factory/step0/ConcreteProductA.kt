package com.asura.design_patterns.factory.step0

import com.asura.design_patterns.ALog

/**
 * @author Created by Asura on 2018/4/12 9:48.
 */
class ConcreteProductA :Product(){
    override fun method() {
        ALog.d("具体产品A")
    }
}