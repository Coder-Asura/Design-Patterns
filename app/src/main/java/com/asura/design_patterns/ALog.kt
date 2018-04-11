package com.asura.design_patterns

import com.orhanobut.logger.LogLevel
import com.orhanobut.logger.Logger
import com.orhanobut.logger.Settings

/**
 * ALog提供INFO、DEBUG、ERROR级别的日志输出，配合Logger的优化，让日志打印输出工作变得更美好一点
 * <p>
 * https://github.com/Coder-Asura/ALog
 * </p>
 * @author Created by Asura on 2017/5/11 15:27.
 */
class ALog {

    companion object {
        private const val TAG = "asura"
        private const val METHOD_LINE = "() : \n"
        private const val SPLIT_LINE = "<---------->%s"
        private const val SPLIT_LINE2 = "<---------->%s\n"
        /**
         * 这里对Logger的一些初始化设置
         */
        fun resetSetting(): Settings {
            return Logger.init(TAG)//设置tag
                    .logLevel(if (BuildConfig.LOG_ENABLE) LogLevel.FULL else LogLevel.NONE)//日志等级
                    .hideThreadInfo()//隐藏线程信息
                    .methodCount(0)//方法数
                    .methodOffset(2)
        }

        /**
         * INFO 级别日志输出
         *
         * @param object 打印的对象，因为使用 Logger ，所以 object 可以为集合对象
         */
        fun i(`object`: Any) {
            Logger.i(`object`.toString())
        }

        /**
         * DEBUG级别日志输出
         *
         * @param title 要打印的信息名称
         * @param args  可变参数，对不同长度做了大致划分,日志大致如下：
         * methodName() :
         * title<---------->message1
         * title2<---------->message2
         * title3<---------->message3
         */
        fun d(title: Any, vararg args: Any) {
            if (args.size == 0) {
                Logger.d(title)
            } else if (args.size == 1) {
                Logger.d(title.toString() + SPLIT_LINE, args[0])
            } else if (args.size == 2) {
                Logger.d(title.toString() + METHOD_LINE + args[0] as String + SPLIT_LINE, args[1])
            } else if (args.size == 3) {
                Logger.d(title.toString() + SPLIT_LINE2 + args[1] + SPLIT_LINE, args[0], args[2])
            } else if (args.size == 4) {
                Logger.d(title.toString() + METHOD_LINE + args[0] as String + SPLIT_LINE2 + args[2] + SPLIT_LINE, args[1], args[3])
            } else if (args.size == 5) {
                Logger.d(title.toString() + SPLIT_LINE2 + args[1] + SPLIT_LINE2 + args[3] + SPLIT_LINE, args[0], args[2], args[4])
            } else if (args.size == 6) {
                Logger.d(title.toString() + METHOD_LINE + args[0] as String + SPLIT_LINE2 + args[2] + SPLIT_LINE2 + args[4] + SPLIT_LINE, args[1], args[3], args[5])
            } else {
                Logger.d(title as String, args)
            }
        }

        /**
         * ERROR 级别日志输出
         *
         * @param title 要打印的信息名称
         * @param args  可变参数，对不同长度做了大致划分,日志大致如下：
         * title<---------->message
         */
        fun e(title: Any, vararg args: Any) {
            if (args.size == 0) {
                Logger.e(title as String)
            } else if (args.size == 1) {
                Logger.e(title.toString() + SPLIT_LINE, args[0])
            } else {
                Logger.e(title as String, args)
            }
        }

        /**
         * ERROR 级别日志输出
         *
         * @param throwable 抛出的异常
         * @param title     异常信息的名称
         * @param args      可变参数，对不同长度做了大致划分,日志大致如下：
         * title<---------->message
         */
        fun e(throwable: Throwable, title: Any, vararg args: Any) {
            if (args.size == 0) {
                Logger.e(throwable, title as String)
            } else if (args.size == 1) {
                Logger.e(throwable, title.toString() + SPLIT_LINE, args[0])
            } else {
                Logger.e(throwable, title as String, args)
            }
        }

        /**
         * 替换默认TAG后，DEBUG级别日志输出
         *
         * @param newTag 更换新的tag
         * @param title  要打印的信息名称
         * @param args   可变参数，对不同长度做了大致划分,日志大致如下：
         * methodName() :
         * title1<---------->message1
         * title2<---------->message2
         * title3<---------->message3
         */
        fun t(newTag: String, title: Any, vararg args: Any) {
            if (args.size == 0) {
                Logger.t(newTag).d(title)
            } else if (args.size == 1) {
                Logger.t(newTag).d(title.toString() + SPLIT_LINE, args[0])
            } else if (args.size == 2) {
                Logger.t(newTag).d(title.toString() + METHOD_LINE + args[0] as String + SPLIT_LINE, args[1])
            } else if (args.size == 3) {
                Logger.t(newTag).d(title.toString() + SPLIT_LINE2 + args[1] + SPLIT_LINE, args[0], args[2])
            } else if (args.size == 4) {
                Logger.t(newTag).d(title.toString() + METHOD_LINE + args[0] as String + SPLIT_LINE2 + args[2] + SPLIT_LINE, args[1], args[3])
            } else if (args.size == 5) {
                Logger.t(newTag).d(title.toString() + SPLIT_LINE2 + args[1] + SPLIT_LINE2 + args[3] + SPLIT_LINE, args[0], args[2], args[4])
            } else if (args.size == 6) {
                Logger.t(newTag).d(title.toString() + METHOD_LINE + args[0] as String + SPLIT_LINE2 + args[2] + SPLIT_LINE2 + args[4] + SPLIT_LINE, args[1], args[3], args[5])
            } else {
                Logger.t(newTag).d(title as String, args)
            }
        }

        /**
         * JSON 字符串的输出
         *
         * @param title 要打印的信息名称
         * @param json  JSON 字符串
         */
        fun json(title: String, json: String) {
            d(title)
            Logger.json(json)
        }

        /**
         * XML 字符串的输出
         *
         * @param title 要打印的信息名称
         * @param xml   XML 字符串
         */
        fun xml(title: String, xml: String) {
            d(title)
            Logger.xml(xml)
        }
    }

}