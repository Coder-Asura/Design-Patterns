package com.asura.design_patterns.principle.imageloader.step2

import android.graphics.Bitmap

/**
 * 定义一个图片缓存接口
 * @author Created by Asura on 2018/4/8 18:37.
 * 这里用到了开闭原则、里式替换原则、依赖倒置原则、接口隔离原则
 * 开闭原则：没有去修改之前的方法，而是同过接口方式去扩展 ImageCache
 * 里式替换：通过抽象建立规范、具体的实现在运行时替换掉抽象，保证系统的扩展性、灵活性
 * 依赖倒置：让ImageLoader 依赖于抽象而不是具体细节
 * 接口隔离：ImageLoader 只需要知道缓存对象有 get 和 put 的接口即可，其他的不管，具体的实现对 ImageLoader 隐藏
 */
public interface ImageCache {
    public fun put(url: String, bitmap: Bitmap)
    public fun get(url: String): Bitmap?
}