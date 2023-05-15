package com.xxx.singleton;

/**
 * 懒汉式
 * 静态内部类 线程安全
 * @author Ether
 */
public class InitializingOnDemandHolderIdiom {

    //私有构造方法
    private InitializingOnDemandHolderIdiom(){}

    // 定义静态内部类
    private static class SingletonHolder {
        //保证被实例化一次
        private static final InitializingOnDemandHolderIdiom INSTANCE = new InitializingOnDemandHolderIdiom();
    }
    // 提供外部访问方法
    public static InitializingOnDemandHolderIdiom getInstance(){
        return SingletonHolder.INSTANCE;
    }
}
