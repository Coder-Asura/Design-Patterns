package com.asura.design_patterns.bulider.step1

import com.asura.design_patterns.bulider.step0.Computer

/**
 * @author Created by Asura on 2018/4/11 13:44.
 */
class SurfaceBuilder : Builder() {
    private var computer: Computer = Surface()
    override fun buildBoard(board: String): Builder {
        computer.board = board
        return this
    }

    override fun buildDisplay(display: String): Builder {
        computer.display = display
        return this
    }

    override fun buildOS(): Builder {
        computer.setOs()
        return this
    }

    override fun build(): Computer {
        return computer
    }

}