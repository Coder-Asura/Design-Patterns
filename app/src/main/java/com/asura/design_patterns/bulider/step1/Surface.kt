package com.asura.design_patterns.bulider.step1

import com.asura.design_patterns.bulider.step0.Computer

/**
 * 具体的产品
 * @author Created by Asura on 2018/4/11 13:49.
 */
class Surface : Computer() {
    override fun setOs() {
        OS = "Windows 10"
    }
}