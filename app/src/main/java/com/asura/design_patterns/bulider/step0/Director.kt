package com.asura.design_patterns.bulider.step0

/**
 * 生产主管：统一组装过程
 *
 * @author Created by Asura on 2018/4/11 11:18.
 */
class Director(var builder: Builder) {

    public fun construct(board: String, display: String) {
        builder.buildBoard(board)
        builder.buildDisplay(display)
        builder.buildOS()
    }

}