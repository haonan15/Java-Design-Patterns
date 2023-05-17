package com.xxx;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 代理对象工厂
 * 获取代理对象（cglib）
 * @author Ether
 */
public class CglibProxyFactory implements MethodInterceptor {

    //声明火车站对象
    TrainStation station = new TrainStation();

    public TrainStation getProxyObject(){
        //创建Enhancer对象，类似JDK中的proxy类
        Enhancer enhancer = new Enhancer();

        //设置父类字节码对象
        enhancer.setSuperclass(TrainStation.class);

        //设置回调函数
        enhancer.setCallback(this);
        //创建代理对象
        TrainStation proxyObject = (TrainStation) enhancer.create();
        return proxyObject;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("代售点收取服务费（Cglib动态代理）");

        Object invoke = method.invoke(station, objects);

        return invoke;
    }
}
