package com.xxx.singleton;

/**
 * 懒汉式
 * 线程安全
 * @author Ether
 */
public class ThreadSafeLazyLoadedSingleton {

    // 私有构造方法
    private ThreadSafeLazyLoadedSingleton(){}

    // 声明本类对象
    private static ThreadSafeLazyLoadedSingleton instance;

    public static synchronized ThreadSafeLazyLoadedSingleton getInstance(){
        // 判断instance是否为空，为空则说明还没有创建该类的对象
        if(instance == null){
            instance = new ThreadSafeLazyLoadedSingleton();
        }
        return instance;
    }
}
