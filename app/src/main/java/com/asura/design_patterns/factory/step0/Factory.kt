package com.asura.design_patterns.factory.step0

/**
 * 抽象工厂类
 * @author Created by Asura on 2018/4/12 9:49.
 */
abstract class Factory {
    /**
     * 抽象工厂方法
     *
     * 具体生产什么由子类去实现
     *
     * @return 具体的产品
     */
    abstract fun createProduct(): Product
}