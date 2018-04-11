package com.asura.design_patterns.bulider.step0

/**
 * 具体的 Builder 类
 * @author Created by Asura on 2018/4/11 11:10.
 */
class MacBookBuilder : Builder() {
    private var computer = MacBook()

    override fun buildBoard(board: String) {
        computer.board = board
    }

    override fun buildDisplay(display: String) {
        computer.display = display
    }

    override fun buildOS() {
        computer.setOs()
    }

    override fun build(): Computer {
        return computer
    }
}