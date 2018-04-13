package com.asura.design_patterns.abstract_factory.step0

/**
 * 抽象工厂角色
 *
 * @author Created by Asura on 2018/4/13 9:43.
 */
abstract class AbstractFactory {
    /**
     * 定义具体工厂需要实现的功能
     */
    abstract fun createProductA(): AbstractProductA

    abstract fun createProductB(): AbstractProductB
}