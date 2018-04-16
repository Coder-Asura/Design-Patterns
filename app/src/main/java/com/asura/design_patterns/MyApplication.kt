package com.asura.design_patterns

import android.app.Application

/**
 * 自定义 Application ，是全局都可以使用 Context
 * @author Created by Asura on 2018/4/16 10:23.
 */
class MyApplication : Application() {
    companion object {
        var mApplication: MyApplication? = null
    }

    override fun onCreate() {
        super.onCreate()
        mApplication = this;
    }
}