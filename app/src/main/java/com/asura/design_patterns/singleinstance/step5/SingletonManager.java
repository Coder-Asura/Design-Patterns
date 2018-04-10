package com.asura.design_patterns.singleinstance.step5;

import java.util.HashMap;
import java.util.Map;

/**
 * 单例模式-使用容器实现
 * 通过统一的接口进行获取操作，降低了使用成本，及耦合度
 *
 * @author Created by Asura on 2018/4/10 17:46.
 */
public class SingletonManager {
    private static Map<String, Object> sObjectMap = new HashMap<>();

    private SingletonManager() {
    }

    public static void registerService(String key, Object instance) {
        if (!sObjectMap.containsKey(key)) {
            sObjectMap.put(key, instance);
        }
    }

    public static Object getService(String key) {
        return sObjectMap.get(key);
    }
}
