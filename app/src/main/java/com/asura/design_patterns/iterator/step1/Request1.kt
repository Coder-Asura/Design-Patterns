package com.asura.design_patterns.iterator.step1

/**
 * 请求者
 *
 * @author Created by Asura on 2018/4/16 18:05.
 */
class Request1(obj1: Any) : BaseRequest(obj1) {
    override fun getRequestLevel(): Int {
        return 1
    }
}