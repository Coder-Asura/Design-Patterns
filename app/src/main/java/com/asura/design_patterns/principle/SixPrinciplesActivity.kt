package com.asura.design_patterns.principle

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.asura.design_patterns.R
import kotlinx.android.synthetic.main.activity_content.*

/**
 * 面向对象的六大原则
 *
 * @author Created by Asura on 2018/3/23 17:10.
 */
class SixPrinciplesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content)
        tv_content.text = resources.getText(R.string.principles)
    }
}
