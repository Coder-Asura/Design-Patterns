package com.asura.design_patterns.principle.renting

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.asura.design_patterns.R
import kotlinx.android.synthetic.main.activity_renting.*

/**
 * 租房测试（迪米特原则示例）
 * @author Created by Asura on 2018/4/10 11:16.
 */
class RentingActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_renting)
        title = getString(R.string.demo_lod)
        btn_demo.setOnClickListener(this)
        btn_lod.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            btn_demo -> {
                //这里耦合太严重
                val tenant = com.asura.design_patterns.principle.renting.step0.Tenant(16f, 2430f)
                tenant.rentRoom(com.asura.design_patterns.principle.renting.step0.Mediator())
            }
            btn_lod -> {
                val tenant = com.asura.design_patterns.principle.renting.step1.Tenant(18f, 2680f)
                tenant.rentRoom(com.asura.design_patterns.principle.renting.step1.Mediator())
            }
        }
    }
}