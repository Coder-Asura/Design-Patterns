package com.asura.design_patterns.principle.imageloader.step2

import android.graphics.Bitmap
import android.util.LruCache

/**
 * @author Created by Asura on 2018/4/8 18:03.
 */
class MemoryCache : ImageCache {
    private var mImageLruCache: LruCache<String, Bitmap>? = null
    public fun MemoryCache() {
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

    override fun put(url: String, bitmap: Bitmap) {
        mImageLruCache?.put(url, bitmap)
    }

    override fun get(url: String): Bitmap? {
        return mImageLruCache?.get(url)
    }
}