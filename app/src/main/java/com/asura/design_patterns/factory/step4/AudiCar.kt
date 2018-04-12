package com.asura.design_patterns.factory.step4

/**
 * 抽象产品类 奥迪车
 *
 * @author Created by Asura on 2018/4/12 10:14.
 */
abstract class AudiCar {
    /**
     * 启动
     */
    abstract fun drive()

    /**
     * 定速巡航
     */
    abstract fun selfNav()
}