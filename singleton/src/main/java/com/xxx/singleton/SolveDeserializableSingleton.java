package com.xxx.singleton;

import java.io.Serializable;

/**
 * 解决反序列化破坏单例模式
 * @author Ether
 */
public class SolveDeserializableSingleton implements Serializable {

    //私有构造
    private SolveDeserializableSingleton(){}

    // 静态内部类
    private static class  SingletonHolder{
        private static final SolveDeserializableSingleton INSTANCE = new SolveDeserializableSingleton();
    }

    public static SolveDeserializableSingleton getInstance(){
        return SingletonHolder.INSTANCE;
    }
    // 当进行反序列化时，会自动调用该方法，将该方法返回值直接返回
    public Object readResolve(){
        return SingletonHolder.INSTANCE;
    }
}
