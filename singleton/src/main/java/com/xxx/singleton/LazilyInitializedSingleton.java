package com.xxx.singleton;

/**
 * 懒汉式
 * 线程不安全
 * @author Ether
 */
public class LazilyInitializedSingleton {

    // 私有构造方法
    private LazilyInitializedSingleton(){}

    // 声明本类对象
    private static LazilyInitializedSingleton instance;

    // 提供静态方法获取并创建对象
    //
    public static LazilyInitializedSingleton getInstance(){
        // 判断instance是否为空，为空则说明还没有创建该类的对象
        if(instance == null){
            // 若线程1进来后等待，CPU执行权给线程2，则线程2也会进入并创建不同的对象实例
            instance = new LazilyInitializedSingleton();
        }
        return instance;
    }
}
