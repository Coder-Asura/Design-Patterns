package com.asura.design_patterns

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.asura.design_patterns.abstract_factory.step0.ConcreteFactory1
import com.asura.design_patterns.abstract_factory.step0.ConcreteFactory2
import com.asura.design_patterns.bulider.step0.Director
import com.asura.design_patterns.bulider.step0.MacBookBuilder
import com.asura.design_patterns.bulider.step1.SurfaceBuilder
import com.asura.design_patterns.factory.step0.ConcreteProductA
import com.asura.design_patterns.factory.step4.AudiCarFactory
import com.asura.design_patterns.factory.step4.AudiQ3
import com.asura.design_patterns.principle.SixPrinciplesActivity
import com.asura.design_patterns.prototype.step0.WordDoc
import com.asura.design_patterns.singleinstance.step0.CEO
import com.asura.design_patterns.singleinstance.step5.SingletonManager
import com.asura.design_patterns.strategy.step0.BusStrategy
import com.asura.design_patterns.strategy.step0.SubwayStrategy
import com.asura.design_patterns.strategy.step0.TaxiStrategy
import com.asura.design_patterns.strategy.step0.TrafficCalculator
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
        names.add(getString(R.string.pattern_factory))
        names.add(getString(R.string.pattern_abstract_factory))
        names.add(getString(R.string.pattern_strategy))
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
        recyclerView!!.adapter = PatternsAdapter(names,
                object : PatternsAdapter.CallBack {
                    override fun onItemClick(view: View, position: Int) {
                        Toast.makeText(this@MainActivity, names.get(position), Toast.LENGTH_SHORT).show()
                        viewDetails(position)
                    }
                }
        )
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
            4 -> {
                factoryDemo()
            }
            5 -> {
                abstractFactoryDemo()
            }
            6 -> {
                strategyDemo()
            }
        }
    }

    private fun strategyDemo() {
        //使用不同的策略计算交通费用
        TrafficCalculator(BusStrategy()).calculatePrice(10)
        TrafficCalculator(SubwayStrategy()).calculatePrice(10)
        TrafficCalculator(TaxiStrategy()).calculatePrice(10)
    }

    private fun abstractFactoryDemo() {
        //实例化一个具体的工厂1
        val factory1 = ConcreteFactory1()
        //具体工厂生产具体的产品
        val productA1 = factory1.createProductA()
        val productB1 = factory1.createProductB()
        //具体产品调用自身实现的抽象产品方法
        productA1.method()
        productB1.method()

        val factory2 = ConcreteFactory2()
        val productA2 = factory2.createProductA()
        val productB2 = factory2.createProductB()
        productA2.method()
        productB2.method()
    }

    private fun factoryDemo() {
        //需要哪个就创建哪个
        val factory = com.asura.design_patterns.factory.step0.ConcreteFactory()
        val product = factory.createProduct()
        product.method()
        //反射创建想要的产品
        val factory1 = com.asura.design_patterns.factory.step1.ConcreteFactory()
        val product1 = factory1.createProduct(ConcreteProductA::class.java);
        product1.method()
        //多工厂方法模式
        val factory2 = com.asura.design_patterns.factory.step2.ConcreteFactoryA()
        val product2 = factory2.createProduct();
        product2.method()
        val factory3 = com.asura.design_patterns.factory.step2.ConcreteFactoryB()
        val product3 = factory3.createProduct();
        product3.method()
        //简单工厂（静态工厂）模式
        val factory4 = com.asura.design_patterns.factory.step3.Factory()
        val product4 = factory4.createProduct()
        product4.method()
        //简单实现
        //构造一个具体的工厂对象
        val audiFactory = AudiCarFactory()
        // 工厂生产Q3
        val audiQ3 = audiFactory.createAudiCar(AudiQ3::class.java)
        audiQ3.drive()
        audiQ3.selfNav()
        // 工厂生产Q5
        val audiQ5 = audiFactory.createAudiCar(AudiQ3::class.java)
        audiQ5.drive()
        audiQ5.selfNav()
        // 工厂生产Q7
        val audiQ7 = audiFactory.createAudiCar(AudiQ3::class.java)
        audiQ7.drive()
        audiQ7.selfNav()
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
