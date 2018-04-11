package com.asura.design_patterns.bulider.step0

/**
 * 具体的产品
 *
 * @author Created by Asura on 2018/4/11 10:55.
 */
class MacBook : Computer() {

    override fun setOs() {
        OS = "Mac OS X 10.10"
    }
}
