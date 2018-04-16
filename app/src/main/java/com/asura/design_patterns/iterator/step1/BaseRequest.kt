package com.asura.design_patterns.iterator.step1

/**
 * 抽象请求者
 *
 * @author Created by Asura on 2018/4/16 17:52.
 */
abstract class BaseRequest(val obj: Any) {

//    val obj: Any? = null

    //具体的处理对象
    public fun getContent(): Any? {
        return obj
    }

    /**
     * 获取请求级别
     */
    public abstract fun getRequestLevel(): Int
}