package com.asura.design_patterns.principle.imageloader.step2

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Environment
import android.util.Log
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException


/**
 * 内存卡缓存
 * @author Created by Asura on 2018/4/8 18:16.
 */
class DiskCache(context: Context) : ImageCache {

    var cacheDir: String = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES).path
//    var cacheDir: String = context.cacheDir.path

    override
    public fun get(url: String): Bitmap? {
        val pathName: String = cacheDir + "/" + imageUrl2MD5(url) + ".png"
        Log.d("asura", pathName)
        return BitmapFactory.decodeFile(pathName)
    }

    override
    public fun put(url: String, bitmap: Bitmap) {
        var fileOutputStream: FileOutputStream? = null

        val file = File(cacheDir);
        if (!file.exists()) {
            file.mkdirs()
        }
        val file2 = File(file, imageUrl2MD5(url) + ".png")
        try {
            fileOutputStream = FileOutputStream(file2)
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream)
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        }
    }

    fun imageUrl2MD5(imageUrl: String): String {
        try {
            //获取md5加密对象
            val instance: MessageDigest = MessageDigest.getInstance("MD5")
            //对字符串加密，返回字节数组
            val digest: ByteArray = instance.digest(imageUrl.toByteArray())
            var sb: StringBuffer = StringBuffer()
            for (b in digest) {
                //获取低八位有效值
                var i: Int = b.toInt() and 0xff
                //将整数转化为16进制
                var hexString = Integer.toHexString(i)
                if (hexString.length < 2) {
                    //如果是一位的话，补0
                    hexString = "0" + hexString
                }
                sb.append(hexString)
            }
            return sb.toString()

        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
        }

        return ""
    }

}