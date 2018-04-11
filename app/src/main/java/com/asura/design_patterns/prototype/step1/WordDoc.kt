package com.asura.design_patterns.prototype.step1

import com.asura.design_patterns.ALog

/**
 * @author Created by Asura on 2018/4/11 14:30.
 */
class WordDoc : Cloneable {
    var text: String? = ""
    var imags = ArrayList<String>()

    fun showDoc() {
        ALog.d("Word Content Start")
        ALog.d("text", "$text", "imags", "$imags")
        ALog.d("asura", "Word Content End")
    }

    public override fun clone(): WordDoc {
        val doc = super.clone() as WordDoc
        doc.text = this.text
        //这里 imags 改成深拷贝
        doc.imags = this.imags.clone() as ArrayList<String>
        return doc
    }

    //clone 产生的实例不会调用构造方法
    init {
        ALog.d("WordDoc 的构造函数")
    }
}