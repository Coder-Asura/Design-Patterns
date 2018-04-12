package com.asura.design_patterns.factory.step2

import com.asura.design_patterns.factory.step0.ConcreteProductB
import com.asura.design_patterns.factory.step0.Factory
import com.asura.design_patterns.factory.step0.Product

/**
 * 多工厂方法模式
 *
 * @author Created by Asura on 2018/4/12 9:52.
 */
class ConcreteFactoryB : Factory() {
    override fun createProduct(): Product {
        // 生产A
        return ConcreteProductB()
    }
}