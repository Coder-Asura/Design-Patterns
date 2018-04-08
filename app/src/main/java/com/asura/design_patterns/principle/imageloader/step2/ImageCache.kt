package com.asura.design_patterns.principle.imageloader.step2

import android.graphics.Bitmap

/**
 * @author Created by Asura on 2018/4/8 18:37.
 * 定义一个图片缓存接口
 */
public interface ImageCache {
    public fun put(url: String, bitmap: Bitmap)
    public fun get(url: String): Bitmap?
}