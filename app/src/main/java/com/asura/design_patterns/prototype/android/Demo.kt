package com.asura.design_patterns.prototype.android

import android.content.Intent
import android.net.Uri

/**
 * @author Created by Asura on 2018/4/12 17:47.
 */
class Demo {
    companion object {
        fun main(args: Array<String>) {
            val uri: Uri = Uri.parse("smsto:123456789")
            val shareIntent: Intent = Intent(Intent.ACTION_SENDTO, uri)
            //克隆副本
            var intent: Intent = shareIntent.clone() as Intent
        }
    }
}