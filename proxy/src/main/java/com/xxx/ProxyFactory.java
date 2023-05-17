package com.xxx;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 获取代理对象的工厂类
 * @author Ether
 */
public class ProxyFactory {

    //声明目标对象
    private TrainStation station = new TrainStation();

    public SellTickets getProxyObject(){
        /**
         * ClassLoader loader：  类加载器，用于加载代理类
         * Class<?>[] interfaces：   代理类实现接口的字节码对象
         * InvocationHandler：    代理对象调用处理
         */
        SellTickets proxyObject = (SellTickets)Proxy.newProxyInstance(
                station.getClass().getClassLoader(),
                station.getClass().getInterfaces(),
                new InvocationHandler() {

                    /**
                     *
                     * @param proxy 代理对象
                     * @param method 对接口中方法进行封装的代理对象
                     * @param args 调用方法的实际参数
                     * @return 方法的返回值
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        // System.out.println("Invoke方法执行");
                        System.out.println("代售点收取服务费（JDK动态代理）");
                        //调用目标方法
                        Object invoke = method.invoke(station, args);
                        return invoke;
                    }
                }
        );

        return proxyObject;
    }

}
