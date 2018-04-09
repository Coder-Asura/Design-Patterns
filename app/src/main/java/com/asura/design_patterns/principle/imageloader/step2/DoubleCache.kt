package com.asura.design_patterns.principle.imageloader.step2

import android.content.Context
import android.graphics.Bitmap

/**
 * 双缓存策略
 * @author Created by Asura on 2018/4/9 17:50.
 */
public class DoubleCache(context: Context) : ImageCache {
    private val memoryCache: ImageCache = MemoryCache()
    private val diskCache: ImageCache = DiskCache(context)

    override fun put(url: String, bitmap: Bitmap) {
        memoryCache.put(url, bitmap)
        diskCache.put(url, bitmap)
    }

    override fun get(url: String): Bitmap? {
        var bitmap: Bitmap? = memoryCache.get(url)
        if (bitmap == null) {
            bitmap = diskCache.get(url)
        }
        return bitmap
    }

}
