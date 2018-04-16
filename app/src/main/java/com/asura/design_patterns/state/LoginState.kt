package com.asura.design_patterns.state

import android.widget.Toast
import com.asura.design_patterns.MyApplication
import com.asura.design_patterns.R

/**
 * 登录状态
 *
 * @author Created by Asura on 2018/4/16 10:22.
 */
class LoginState : UserState {

    override fun forward() {
        Toast.makeText(MyApplication.mApplication, R.string.forward, Toast.LENGTH_SHORT).show()
    }

    override fun comment() {
        Toast.makeText(MyApplication.mApplication, R.string.comment, Toast.LENGTH_SHORT).show()
    }
}