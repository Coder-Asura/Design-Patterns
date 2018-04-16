package com.asura.design_patterns.state

/**
 * 用户状态接口，定义用户操作
 *
 * @author Created by Asura on 2018/4/16 10:19.
 */
interface UserState {
    /**
     * 转发
     */
    fun forward()

    /**
     * 评论
     */
    fun comment()
}