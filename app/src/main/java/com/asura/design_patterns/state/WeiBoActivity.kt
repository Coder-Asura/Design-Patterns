package com.asura.design_patterns.state

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.asura.design_patterns.R
import kotlinx.android.synthetic.main.activity_state_weibo.*

/**
 * 微博页面
 *
 * @author Created by Asura on 2018/4/13 16:39.
 */
class WeiBoActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_state_weibo)
        btn_forward.setOnClickListener(this)
        btn_comment.setOnClickListener(this)
        btn_logout.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            btn_forward -> {
                LoginContext.getInstance()!!.forward()
            }
            btn_comment -> {
                LoginContext.getInstance()!!.comment()
            }
            btn_logout -> {
                Toast.makeText(this@WeiBoActivity, "注销成功", Toast.LENGTH_SHORT).show()
                LoginContext.getInstance()!!.setState(LogoutState())
                startActivity(Intent(this@WeiBoActivity, LoginActivity::class.java))
                finish()
            }
        }
    }
}