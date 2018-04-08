package com.asura.design_patterns.principle.imageloader.step2

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException

/**
 * 内存卡缓存
 * @author Created by Asura on 2018/4/8 18:16.
 */
class DiskCache : ImageCache {
    //todo 这里可能需要权限，暂时不管
    val cacheDir: String = "sdcard/cache/"

    override
    public fun get(url: String): Bitmap {
        return BitmapFactory.decodeFile(cacheDir + url)
    }

    override
    public fun put(url: String, bitmap: Bitmap) {
        var fileOutputStream: FileOutputStream? = null
        try {
            fileOutputStream = FileOutputStream(cacheDir + url)
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream)
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        }
    }
}