package com.asura.design_patterns.factory.step4

/**
 * 抽象工厂类
 *
 * @author Created by Asura on 2018/4/12 10:14.
 */
abstract class AudiFactory {
    abstract fun <T : AudiCar> createAudiCar(clazz: Class<T>): T
}