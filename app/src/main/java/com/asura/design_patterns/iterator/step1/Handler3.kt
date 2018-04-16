package com.asura.design_patterns.iterator.step1

import com.asura.design_patterns.ALog

/**
 * 具体的处理者
 *
 * @author Created by Asura on 2018/4/16 18:00.
 */
class Handler3 : BaseHandler() {
    override fun getHandlerLevel(): Int {
        return 3
    }

    override fun handle(request: BaseRequest) {
        ALog.d("Handler3 handled-->" + getHandlerLevel())
    }
}