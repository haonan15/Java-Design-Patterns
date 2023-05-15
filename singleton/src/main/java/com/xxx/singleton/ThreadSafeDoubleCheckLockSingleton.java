package com.xxx.singleton;

/**
 * 双重检查锁
 * 线程安全 多线程情况下可能会出现空指针问题，需要使用volatile
 * @author Ether
 */
public class ThreadSafeDoubleCheckLockSingleton {

    //私有构造方法
    private ThreadSafeDoubleCheckLockSingleton(){}

    // 声明当前类的变量
    private static volatile ThreadSafeDoubleCheckLockSingleton instance;

    // 对外提供公共访问方式
    public static ThreadSafeDoubleCheckLockSingleton getInstance(){
        //
        if (instance == null){
            synchronized (ThreadSafeDoubleCheckLockSingleton.class){
                if (instance == null) {
                    instance = new ThreadSafeDoubleCheckLockSingleton();
                }
            }
        }
        return instance;
    }
}
