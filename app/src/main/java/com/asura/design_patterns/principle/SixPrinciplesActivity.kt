package com.asura.design_patterns.principle

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.asura.design_patterns.R
import kotlinx.android.synthetic.main.activity_principle.*

/**
 * 面向对象的六大原则
 *
 * @author Created by Asura on 2018/3/23 17:10.
 */
class SixPrinciplesActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principle)
        title = getString(R.string.principles)
        btn_demo.setOnClickListener(this)
        btn_srp.setOnClickListener(this)
        btn_ocp.setOnClickListener(this)
        btn_lod.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val intent = Intent()
        when (v) {
            btn_demo -> {
                intent.setClass(this@SixPrinciplesActivity,
                        com.asura.design_patterns.principle.imageloader.step0.TestActivity::class.java)
            }
            btn_srp -> {
                intent.setClass(this@SixPrinciplesActivity,
                        com.asura.design_patterns.principle.imageloader.step1.TestActivity::class.java)
            }
            btn_ocp -> {
                intent.setClass(this@SixPrinciplesActivity,
                        com.asura.design_patterns.principle.imageloader.step2.TestActivity::class.java)
            }
            btn_lod -> {
                intent.setClass(this@SixPrinciplesActivity,
                        com.asura.design_patterns.principle.renting.RentingActivity::class.java)
            }
        }
        startActivity(intent)
    }
}
