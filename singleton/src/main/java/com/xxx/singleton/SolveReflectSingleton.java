package com.xxx.singleton;

/**
 * 解决反射破坏单例模式
 * @author Ether
 */
public class SolveReflectSingleton {

    private static boolean flag = false;

    // 私有构造方法
    private SolveReflectSingleton(){

        //多线程环境
        synchronized (SolveReflectSingleton.class) {
            // 判断flag值是否是true，为true则说明非第一次访问，为false则为第一次访问
            if (flag) {
                throw new RuntimeException("不能创建多个对象");
            }
            flag = true;
        }
    }

    private static class SingletonHolder{
        private static final SolveReflectSingleton INSTANCE = new SolveReflectSingleton();
    }

    public static SolveReflectSingleton getInstance(){
        return SolveReflectSingleton.SingletonHolder.INSTANCE;
    }
}
