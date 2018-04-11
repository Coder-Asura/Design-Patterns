package com.asura.design_patterns.bulider.step0

/**
 * 计算机抽象类，即 Product 角色
 * @author Created by Asura on 2018/4/11 10:50.
 */
abstract class Computer {

    var board: String? = ""

    var display: String? = ""

    var OS: String? = ""

    abstract fun setOs()

    override fun toString(): String {
        return "Computer(board='$board', display='$display', OS='$OS')"
    }
}