package com.asura.design_patterns.abstract_factory.step0

import com.asura.design_patterns.ALog

/**
 * 具体产品角色B2
 *
 * @author Created by Asura on 2018/4/13 9:46.
 */
class ConcreteProductB2:AbstractProductB() {
    override fun method() {
        ALog.d("我是具体产品角色B2 调用的方法")
    }
}