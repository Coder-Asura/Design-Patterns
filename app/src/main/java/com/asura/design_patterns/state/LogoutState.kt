package com.asura.design_patterns.state

import android.content.Intent
import android.widget.Toast
import com.asura.design_patterns.MyApplication

/**
 * 未登录状态
 *
 * @author Created by Asura on 2018/4/16 10:35.
 */
class LogoutState : UserState {

    override fun comment() {
        jumpToLogin()
    }

    override fun forward() {
        jumpToLogin()
    }

    private fun jumpToLogin() {
        Toast.makeText(MyApplication.mApplication, "还没登录呢", Toast.LENGTH_SHORT).show()
        MyApplication.mApplication?.startActivity(Intent(MyApplication.mApplication, LoginActivity::class.java))
    }
}