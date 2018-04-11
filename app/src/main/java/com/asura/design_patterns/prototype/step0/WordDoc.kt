package com.asura.design_patterns.prototype.step0

import android.util.Log

/**
 * @author Created by Asura on 2018/4/11 14:30.
 */
class WordDoc : Cloneable {
    var text: String? = ""
    var imags = ArrayList<String>()

    fun showDoc() {
        Log.d("asura", "Word Content Start")
        Log.d("asura", "text:$text")
        imags.forEach {
            Log.d("asura", "imags:" + it)
        }
        Log.d("asura", "Word Content End")
    }

    public override fun clone(): WordDoc {
        val doc = super.clone() as WordDoc
        doc.text = this.text
        //这里只是浅拷贝
        doc.imags = this.imags
        return doc
    }

    //clone 产生的实例不会调用构造方法
    init {
        Log.d("asura", "WordDoc 的构造函数")
    }
}