package com.asura.design_patterns.singleinstance.step1;

import com.asura.design_patterns.singleinstance.Staff;

/**
 * SingletonManager，懒汉单例模式
 *
 * @author Created by Asura on 2018/4/10 18:11.
 */
public class CEO extends Staff {
    private static CEO instance;

    private CEO() {
    }

    public synchronized static CEO getCEO() {
        if (instance == null) {
            instance = new CEO();
        }
        return instance;
    }

    @Override
    public void work() {
        super.work();
        //管理下面的VP
    }
}
