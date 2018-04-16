package com.asura.design_patterns.iterator.step0

/**
 * 抽象处理者
 *
 * @author Created by Asura on 2018/4/16 17:37.
 */
abstract class Handler {
    /**
     * 下一个节点的处理者
     */
    public var successor: Handler? = null

    /**
     * 处理请求
     * @param condition 请求条件
     */
    public abstract fun handleRequest(condition: String)
}