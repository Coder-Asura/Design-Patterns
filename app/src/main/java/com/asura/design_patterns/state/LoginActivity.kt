package com.asura.design_patterns.state

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.asura.design_patterns.R
import kotlinx.android.synthetic.main.activity_state_login.*

/**
 * 登录页面
 *
 * @author Created by Asura on 2018/4/13 16:39.
 */
class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_state_login)
        btn_login.setOnClickListener(View.OnClickListener {
            login()
        })
    }

    private fun login() {
        //判空、格式校验
        //执行登录请求操作
        Thread.sleep(1000)
        Toast.makeText(this@LoginActivity, et_username.text.toString() + "->"
                + et_psw.text.toString(), Toast.LENGTH_SHORT).show()
        //设置为登录状态
        LoginContext.getInstance()!!.setState(LoginState())
        startActivity(Intent(this@LoginActivity, WeiBoActivity::class.java))
        finish()
    }
}