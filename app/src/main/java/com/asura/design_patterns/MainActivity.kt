package com.asura.design_patterns

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.asura.design_patterns.principle.SixPrinciplesActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var names: ArrayList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initData()
    }

    private fun initData() {
        names = ArrayList<String>()
        names.add("六大原则")
        names.add("单例模式")
        names.add("Builder模式")
        names.add("原型模式")
        names.add("工厂方法模式")
        names.add("抽象工厂方法模式")
        names.add("策略模式")
        names.add("状态模式")
        names.add("责任链模式")
        names.add("解释器模式")
        names.add("命令模式")
        names.add("观察者模式")
        names.add("备忘录模式")
        names.add("迭代器模式")
        names.add("模板方法模式")
        names.add("访问者模式")
        names.add("中介者模式")
        names.add("代理模式")
        names.add("组合模式")
        names.add("适配器模式")
        names.add("装饰模式")
        names.add("享元模式")
        names.add("外观模式")
        names.add("桥接模式")
        names.add("MVC")
        names.add("MVP")
        names.add("MVVM")
        recyclerView!!.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView!!.adapter = PatternsAdapter(names, PatternsAdapter.CallBack { view, position ->
            Toast.makeText(this, names.get(position), Toast.LENGTH_SHORT).show()
            viewDetails(position)
        })
    }

    private fun viewDetails(position: Int) {
        when (position) {
            0 -> {
                val intent = Intent()
                intent.putExtra("content", resources.getString(R.string.app_name))
                intent.setClass(this@MainActivity, SixPrinciplesActivity::class.java)
                startActivity(intent)
            }
            1 -> {
                val intent = Intent()
                intent.putExtra("content", resources.getString(R.string.app_name)+names[position])
                intent.setClass(this@MainActivity, SixPrinciplesActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
