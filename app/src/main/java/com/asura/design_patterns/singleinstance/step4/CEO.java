package com.asura.design_patterns.singleinstance.step4;

/**
 * 单例模式-枚举实现
 * 默认枚举实例的创建是线程安全的，并且在任何情况下它都是一个单例，包括反序列化的时候
 * @author Created by Asura on 2018/4/10 16:19.
 */
public enum CEO {
    INSTANCE;
}
