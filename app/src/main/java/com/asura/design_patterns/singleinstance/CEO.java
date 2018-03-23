package com.asura.design_patterns.singleinstance;

/**
 * @author Created by Asura on 2018/3/23 18:11.
 *         CEO，饿汉单例模式
 */
public class CEO extends Staff {
    private static final CEO mCEO = new CEO();

    private CEO() {
    }

    public static CEO getCEO() {
        return mCEO;
    }

    @Override
    public void work() {
        super.work();
        //管理下面的VP
    }
}
