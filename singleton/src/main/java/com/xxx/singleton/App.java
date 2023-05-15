package com.xxx.singleton;

/**
 * 测试
 * @author Ether
 */
public class App {
    public static void main(String[] args) {
        // 饿汉式 静态变量创建类的对象
        EagerlyInitializedSingleton eagerlyInitializedSingleton1 = EagerlyInitializedSingleton.getInstance();
        EagerlyInitializedSingleton eagerlyInitializedSingleton2 = EagerlyInitializedSingleton.getInstance();
        System.out.println(eagerlyInitializedSingleton1 == eagerlyInitializedSingleton2);   //true

        //饿汉式 枚举
        EnumSingleton enumSingleton1 = EnumSingleton.INSTANCE;
        EnumSingleton enumSingleton2 = EnumSingleton.INSTANCE;
        System.out.println(enumSingleton1 == enumSingleton2);   //true

        // 懒汉式 线程不安全
        LazilyInitializedSingleton lazilyInitializedSingleton1 = LazilyInitializedSingleton.getInstance();
        LazilyInitializedSingleton lazilyInitializedSingleton2 = LazilyInitializedSingleton.getInstance();
        System.out.println(lazilyInitializedSingleton1 == lazilyInitializedSingleton2);  //false

        // 懒汉式 线程安全
        ThreadSafeLazyLoadedSingleton threadSafeLazyLoadedSingleton1 = ThreadSafeLazyLoadedSingleton.getInstance();
        ThreadSafeLazyLoadedSingleton threadSafeLazyLoadedSingleton2 = ThreadSafeLazyLoadedSingleton.getInstance();
        System.out.println(threadSafeLazyLoadedSingleton1 == threadSafeLazyLoadedSingleton2); // true

        // 懒汉式 双重检查锁 线程安全 多线程情况下可能会出现空指针问题，需要使用volatile
        ThreadSafeDoubleCheckLockSingleton threadSafeDoubleCheckLockSingleton1 = ThreadSafeDoubleCheckLockSingleton.getInstance();
        ThreadSafeDoubleCheckLockSingleton threadSafeDoubleCheckLockSingleton2 = ThreadSafeDoubleCheckLockSingleton.getInstance();
        System.out.println(threadSafeDoubleCheckLockSingleton1 == threadSafeDoubleCheckLockSingleton2); //true

        //懒汉式 静态内部类
        InitializingOnDemandHolderIdiom initializingOnDemandHolderIdiom1 = InitializingOnDemandHolderIdiom.getInstance();
        InitializingOnDemandHolderIdiom initializingOnDemandHolderIdiom2 = InitializingOnDemandHolderIdiom.getInstance();
        System.out.println(initializingOnDemandHolderIdiom1 == initializingOnDemandHolderIdiom2);   //true


    }
}
