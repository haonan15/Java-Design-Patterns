package com.xxx.singleton;

/**
 * 静态变量创建类的对象
 * @author Ether
 */
public class EagerlyInitializedSingleton {

    // 私有构造方法
    private EagerlyInitializedSingleton(){}

    // 在本类中创建本类对象
    private static EagerlyInitializedSingleton instance = new EagerlyInitializedSingleton();

    // 提供一个公共访问方式，让外界获取该对象
    public static EagerlyInitializedSingleton getInstance(){
        return instance;
    }
}
