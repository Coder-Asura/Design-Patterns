package com.asura.design_patterns.principle

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.asura.design_patterns.R
import kotlinx.android.synthetic.main.activity_principle.*

/**
 * 面向对象的六大原则
 *
 * @author Created by Asura on 2018/3/23 17:10.
 */
class SixPrinciplesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principle)
        btn_demo.setOnClickListener { v ->
            startActivity(Intent(this@SixPrinciplesActivity,
                    com.asura.design_patterns.principle.imageloader.step0.TestActivity::class.java))
        }
        btn_srp.setOnClickListener { v ->
            startActivity(Intent(this@SixPrinciplesActivity,
                    com.asura.design_patterns.principle.imageloader.step1.TestActivity::class.java))
        }
        btn_ocp.setOnClickListener { v ->
            startActivity(Intent(this@SixPrinciplesActivity,
                    com.asura.design_patterns.principle.imageloader.step2.TestActivity::class.java))
        }
    }
}
