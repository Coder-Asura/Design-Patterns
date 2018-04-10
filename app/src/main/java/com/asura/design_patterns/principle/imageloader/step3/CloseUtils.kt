package com.asura.design_patterns.principle.imageloader.step3

import java.io.Closeable
import java.io.IOException

/**
 * @author Created by Asura on 2018/4/10 9:52.
 * 接口隔离原则
 */
public class CloseUtils {
    private constructor()

    companion object {
        public fun closeQuietly(closeable: Closeable?) {
            if (closeable == null) {
                return
            }
            try {
                closeable.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }
}
