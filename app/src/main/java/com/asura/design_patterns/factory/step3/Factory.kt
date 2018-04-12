package com.asura.design_patterns.factory.step3

import com.asura.design_patterns.factory.step0.ConcreteProductA
import com.asura.design_patterns.factory.step0.Product

/**
 * 抽象工厂类
 *
 * 简单工厂（静态工厂）模式
 * @author Created by Asura on 2018/4/12 9:49.
 */
class Factory {
    fun createProduct(): Product {
        return ConcreteProductA()
//        return ConcreteProductB()
    }
}