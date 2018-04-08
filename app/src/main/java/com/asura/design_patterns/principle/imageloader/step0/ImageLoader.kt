package com.asura.design_patterns.principle.imageloader.step0

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.LruCache
import android.widget.ImageView
import java.net.HttpURLConnection
import java.net.URL
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

/**
 * 图片加载类
 * @author Created by Asura on 2018/4/8 17:13.
 */
class ImageLoader {
    private var mImageLruCache: LruCache<String, Bitmap>? = null
    private var mExecutorService: ExecutorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors())
    public fun ImageLoader1() {
        initLruCache();
    }

    private fun initLruCache() {
        val maxMemory: Int = (Runtime.getRuntime().maxMemory() / 1024).toInt()
        val cacheSize: Int = maxMemory / 4
        mImageLruCache = object : LruCache<String, Bitmap>(cacheSize) {
            override fun sizeOf(key: String, value: Bitmap): Int {
                return value.rowBytes * value.height / 1024
            }
        }
    }

    public fun displayImage(url: String, imageview: ImageView) {
        val bitmap: Bitmap? = mImageLruCache?.get(url)
        if (bitmap != null) {
            imageview.setImageBitmap(bitmap)
            return
        }
        imageview.tag = url
        mExecutorService.submit(object : Runnable {
            override fun run() {
                val bitmap1: Bitmap = downLoadImage(url) ?: return
                if (imageview.tag.equals(url)) {
                    imageview.setImageBitmap(bitmap1)
                }
                mImageLruCache?.put(url, bitmap1)
            }
        })
    }

    private fun downLoadImage(imageUrl: String): Bitmap? {
        var bitmap: Bitmap? = null
        try {
            val url: URL = URL(imageUrl)
            val conn: HttpURLConnection = url.openConnection() as HttpURLConnection
            bitmap = BitmapFactory.decodeStream(conn.inputStream)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return bitmap
    }
}