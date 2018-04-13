package com.asura.design_patterns.abstract_factory.step0

/**
 * 具体工厂角色2
 *
 * @author Created by Asura on 2018/4/13 9:48.
 */
class ConcreteFactory2 : AbstractFactory() {
    override fun createProductA(): AbstractProductA {
        return ConcreteProductA2()
    }

    override fun createProductB(): AbstractProductB {
        return ConcreteProductB2()
    }

}