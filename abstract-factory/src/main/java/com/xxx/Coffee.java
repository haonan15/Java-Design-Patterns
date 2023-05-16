package com.xxx;

/**
 * 抽象咖啡类
 * @author Ether
 */
public abstract class Coffee {

    public abstract String getName();

    public void addMilk(){
        System.out.println("加奶");
    }

    public void addSugar(){
        System.out.println("加糖");
    }

}
