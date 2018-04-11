package com.asura.design_patterns.bulider.step1

import com.asura.design_patterns.bulider.step0.Computer

/**
 * 抽象 Builder 类
 *
 * 每个构建方法都返回本身，方便链式调用
 * @author Created by Asura on 2018/4/11 11:08.
 */
abstract class Builder {
    abstract fun buildBoard(board: String): Builder
    abstract fun buildDisplay(display: String): Builder
    abstract fun buildOS(): Builder
    abstract fun build(): Computer
}