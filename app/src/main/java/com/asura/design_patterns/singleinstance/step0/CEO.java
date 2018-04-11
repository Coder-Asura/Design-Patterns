package com.asura.design_patterns.singleinstance.step0;

import com.asura.design_patterns.singleinstance.Staff;

/**
 * SingletonManager，饿汉单例模式
 *
 * @author Created by Asura on 2018/3/23 18:11.
 */
public class CEO extends Staff {
    private static final CEO CEO = new CEO();

    private CEO() {
    }

    public static CEO getCEO() {
        return CEO;
    }

    @Override
    public void work() {
        super.work();
        //管理下面的VP
    }
}
