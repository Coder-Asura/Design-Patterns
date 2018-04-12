package com.asura.design_patterns.factory.step4

/**
 * 具体的工厂类
 *
 * @author Created by Asura on 2018/4/12 10:21.
 */
class AudiCarFactory : AudiFactory() {
    override fun <T : AudiCar> createAudiCar(clazz: Class<T>): T {
        var audiCar: AudiCar? = null
        //kotlin 没有check exception ,无需try catch
        audiCar = Class.forName(clazz.name).newInstance() as AudiCar?
        return audiCar as T
    }
}