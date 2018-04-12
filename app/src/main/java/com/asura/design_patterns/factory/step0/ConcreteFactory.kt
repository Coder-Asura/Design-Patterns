package com.asura.design_patterns.factory.step0

/**
 * @author Created by Asura on 2018/4/12 9:52.
 */
class ConcreteFactory:Factory() {
    override fun createProduct(): Product {
        // 需要生成哪个就生产哪个
//        return ConcreteProductA()
        return ConcreteProductB()
    }
}