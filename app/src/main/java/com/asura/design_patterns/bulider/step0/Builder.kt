package com.asura.design_patterns.bulider.step0

/**
 * 抽象 Builder 类
 * @author Created by Asura on 2018/4/11 11:08.
 */
abstract class Builder {
    abstract fun buildBoard(board: String)
    abstract fun buildDisplay(display: String)
    abstract fun buildOS()
    abstract fun build(): Computer
}