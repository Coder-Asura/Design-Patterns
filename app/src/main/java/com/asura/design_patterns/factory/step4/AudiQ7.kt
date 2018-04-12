package com.asura.design_patterns.factory.step4

import com.asura.design_patterns.ALog

/**
 * 具体的奥迪车产品 Q7
 *
 * @author Created by Asura on 2018/4/12 10:17.
 */
class AudiQ7 : AudiCar() {
    override fun drive() {
        ALog.d("Q7 启动")
    }

    override fun selfNav() {
        ALog.d("Q7 定速巡航")
    }
}