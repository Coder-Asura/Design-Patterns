package com.asura.design_patterns.principle.imageloader.step1

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import android.widget.ImageView
import java.net.HttpURLConnection
import java.net.URL
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

/**
 * 图片加载类(单一职责原则)
 * @author Created by Asura on 2018/4/8 17:13.
 */
class ImageLoader {
    private var mImageLruCache: ImageCache? = null
    private var mExecutorService: ExecutorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors())

    public fun displayImage(url: String, imageview: ImageView) {
        val bitmap: Bitmap? = mImageLruCache?.get(url)
        if (bitmap != null) {
            Log.d("asura", "有缓存")
            imageview.setImageBitmap(bitmap)
            return
        }
        Log.d("asura", "没缓存")
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