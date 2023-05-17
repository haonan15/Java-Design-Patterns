package com.xxx;

/**
 * @author Ether
 */
public class App {

    public static void main(String[] args) {
        //静态代理
        ProxyPoint point = new ProxyPoint();
        point.sell();

        //JDK获取代理对象
        //创建代理工厂
        ProxyFactory factory = new ProxyFactory();
        //获取代理对象
        SellTickets proxyObject = factory.getProxyObject();
        //调用方法
        proxyObject.sell();

        // System.out.println(proxyObject.getClass());
        // while (true){}

        //Cglib
        CglibProxyFactory factory1 = new CglibProxyFactory();
        TrainStation proxyObject1 = factory1.getProxyObject();
        proxyObject1.sell();
    }
}
