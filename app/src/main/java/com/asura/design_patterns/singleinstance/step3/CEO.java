package com.asura.design_patterns.singleinstance.step3;

import java.io.ObjectStreamException;

/**
 * 单例模式-静态内部类实现
 * 反序列化相关：https://www.cnblogs.com/345214483-qq/p/6472158.html
 *
 * @author Created by Asura on 2018/4/10 16:19.
 */
public class CEO {
    private CEO() {
    }

    private static CEO instance = null;

    public static CEO getInstance() {
        return CEOHolder.instance;
    }

    /**
     * 静态内部类
     * 确保线程安全，也能保证单例对象的唯一性
     * 延时了单例的初始化
     */
    private static class CEOHolder {
        private static final CEO instance = new CEO();
    }

    //防止反序列化时，可以通过反射来创建新对象
    private Object readResolve() throws ObjectStreamException {
        return getInstance();
    }
}
