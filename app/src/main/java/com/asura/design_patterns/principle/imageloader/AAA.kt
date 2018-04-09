package com.asura.design_patterns.principle.imageloader

import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream

/**
 * @author Created by Asura on 2018/4/9 16:40.
 */
class AAA {
    internal var cacheDir = ""

    private fun put() {
        var mFileOutputStream: FileOutputStream? = null
        val mFile = File(cacheDir)
        if (!mFile.exists()) {
            mFile.mkdirs()
        }
        try {
            mFileOutputStream = FileOutputStream(mFile)
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        }

    }

}
