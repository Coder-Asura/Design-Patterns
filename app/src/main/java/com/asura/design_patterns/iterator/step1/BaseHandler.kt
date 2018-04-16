package com.asura.design_patterns.iterator.step1

import com.asura.design_patterns.ALog

/**
 * @author Created by Asura on 2018/4/16 17:51.
 */
abstract class BaseHandler {
    public var nextHandler: BaseHandler? = null

    public fun handleRequest(request: BaseRequest) {
        if (getHandlerLevel() == request.getRequestLevel()) {
            handle(request)
        } else {
            if (nextHandler != null) {
                nextHandler!!.handleRequest(request)
            } else {
                ALog.d("没谁能处理了")
            }
        }
    }

    protected abstract fun getHandlerLevel(): Int

    protected abstract fun handle(request: BaseRequest)
}
