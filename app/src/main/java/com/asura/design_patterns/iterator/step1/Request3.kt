package com.asura.design_patterns.iterator.step1

/**
 * 请求者
 *
 * @author Created by Asura on 2018/4/16 18:05.
 */
class Request3(obj3: Any) : BaseRequest(obj3) {
    override fun getRequestLevel(): Int {
        return 3
    }
}