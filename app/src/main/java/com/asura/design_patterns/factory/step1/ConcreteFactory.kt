package com.asura.design_patterns.factory.step1

import com.asura.design_patterns.factory.step0.Product

/**
 * @author Created by Asura on 2018/4/12 10:00.
 */
class ConcreteFactory : Factory() {

    override fun <T : Product> createProduct(clazz: Class<T>): T {
        var product: Product? = null;
        product = Class.forName(clazz.name).newInstance() as Product?
        return product as T;

    }
}