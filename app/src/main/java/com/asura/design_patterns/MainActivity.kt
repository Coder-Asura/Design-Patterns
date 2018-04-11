package com.asura.design_patterns

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.asura.design_patterns.bulider.step0.Director
import com.asura.design_patterns.bulider.step0.MacBookBuilder
import com.asura.design_patterns.bulider.step1.SurfaceBuilder
import com.asura.design_patterns.principle.SixPrinciplesActivity
import com.asura.design_patterns.prototype.step0.WordDoc
import com.asura.design_patterns.singleinstance.step0.CEO
import com.asura.design_patterns.singleinstance.step5.SingletonManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var names: ArrayList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //初始化日志配置
        ALog.resetSetting();
        //初始化集合数据
        initData()
    }

    private fun initData() {
        names = ArrayList<String>()
        names.add(getString(R.string.principles))
        names.add(getString(R.string.pattern_single_instance))
        names.add(getString(R.string.pattern_builder))
        names.add(getString(R.string.pattern_prototype))
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
                principleDemo()
            }
            1 -> {
                singleInstanceDemo()
            }
            2 -> {
                builderDemo()
            }
            3 -> {
                prototypeDemo()
            }
        }
    }

    private fun prototypeDemo() {
        // 浅拷贝 demo
        ALog.d("----------浅拷贝 demo------------")
        ALog.d("----------创建原文档------------")
        val originDoc = WordDoc()
        originDoc.text = "这是第一个文档"
        originDoc.imags.add("苍井空.jpg")
        originDoc.imags.add("饭岛爱.jpg")
        originDoc.imags.add("天使翼.jpg")
        originDoc.showDoc()
        ALog.d("----------clone文档------------")
        val cloneDoc = originDoc.clone()
        cloneDoc.showDoc()
        ALog.d("----------修改clone的文档 text------------")
        cloneDoc.text = "修改原文档里的内容"
        cloneDoc.showDoc()
        ALog.d("----------修改clone后的原文档------------")
        originDoc.showDoc()
        ALog.d("----------修改clone的文档 imags------------")
        //浅拷贝会影响原型对象
        cloneDoc.imags.add("武藤兰.jpg")
        cloneDoc.showDoc()
        ALog.d("----------修改clone后的原文档------------")
        originDoc.showDoc()

        //深拷贝 demo
        ALog.d("----------深拷贝 demo------------")
        ALog.d("----------创建原文档------------")
        val originDoc1 = com.asura.design_patterns.prototype.step1.WordDoc()
        originDoc1.text = "这是第一个文档"
        originDoc1.imags.add("苍井空.jpg")
        originDoc1.imags.add("饭岛爱.jpg")
        originDoc1.imags.add("天使翼.jpg")
        originDoc1.showDoc()
        ALog.d("----------clone文档------------")
        val cloneDoc1 = originDoc1.clone()
        cloneDoc1.showDoc()
        ALog.d("----------修改clone的文档 text------------")
        cloneDoc1.text = "修改原文档里的内容"
        cloneDoc1.showDoc()
        ALog.d("----------修改clone后的原文档------------")
        originDoc1.showDoc()
        ALog.d("----------修改clone的文档 imags------------")
        //浅拷贝会影响原型对象
        cloneDoc1.imags.add("武藤兰.jpg")
        cloneDoc1.showDoc()
        ALog.d("----------修改clone后的原文档------------")
        originDoc1.showDoc()
    }

    private fun builderDemo() {
        val builder = MacBookBuilder()
        val director = Director(builder)
        director.construct("Apple", "Apple Retina Display")
        val computer = builder.build()
        ALog.d(computer.toString())

        val builder1 = SurfaceBuilder()
        val computer1 = builder1.buildBoard("ASUS B350")
                .buildDisplay("SamSung 34\" Display")
                .build()
        ALog.d(computer1.toString())
    }

    private fun singleInstanceDemo() {
        //创建单例
        val ceo0 = CEO.getCEO()
        val ceo1 = com.asura.design_patterns.singleinstance.step1.CEO.getCEO()
        val ceo2 = com.asura.design_patterns.singleinstance.step2.CEO.getInstance()
        val ceo3 = com.asura.design_patterns.singleinstance.step3.CEO.getInstance()
        val ceo4 = com.asura.design_patterns.singleinstance.step4.CEO.INSTANCE
        //加入到集合容器中管理
        SingletonManager.registerService("ceo0", ceo0)
        SingletonManager.registerService("ceo1", ceo1)
        SingletonManager.registerService("ceo2", ceo2)
        SingletonManager.registerService("ceo3", ceo3)
        SingletonManager.registerService("ceo4", ceo4)
        //重新获取一次单例
        val ceo02 = CEO.getCEO()
        val ceo12 = com.asura.design_patterns.singleinstance.step1.CEO.getCEO()
        val ceo22 = com.asura.design_patterns.singleinstance.step2.CEO.getInstance()
        val ceo32 = com.asura.design_patterns.singleinstance.step3.CEO.getInstance()
        val ceo42 = com.asura.design_patterns.singleinstance.step4.CEO.INSTANCE
        //比较两次实例是否相同
        ALog.d((ceo02 == ceo0).toString());
        ALog.d((ceo12 == ceo1).toString());
        ALog.d((ceo22 == ceo2).toString());
        ALog.d((ceo32 == ceo3).toString());
        ALog.d((ceo42 == ceo4).toString());
        //和容器里的单例做比较
        ALog.d((ceo02 == SingletonManager.getService("ceo0")).toString());
        ALog.d((ceo12 == SingletonManager.getService("ceo1")).toString());
        ALog.d((ceo22 == SingletonManager.getService("ceo2")).toString());
        ALog.d((ceo32 == SingletonManager.getService("ceo3")).toString());
        ALog.d((ceo42 == SingletonManager.getService("ceo4")).toString());
    }

    private fun principleDemo() {
        startActivity(Intent(this@MainActivity, SixPrinciplesActivity::class.java))
    }
}
