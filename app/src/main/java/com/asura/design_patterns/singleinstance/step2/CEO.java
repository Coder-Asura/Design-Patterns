package com.asura.design_patterns.singleinstance.step2;

/**
 * 懒汉模式-double checkLock
 *
 * @author Created by Asura on 2018/4/10 16:19.
 */
public class CEO {
    private CEO() {
    }

    private static CEO instance = null;

    public static CEO getInstance() {
        //避免不必要的同步
        if (instance == null) {
            synchronized (CEO.class) {
                //同步后仍然为null，再创建
                if (instance == null) {
                    instance = new CEO();
                }
            }
        }
        return instance;
    }
}
