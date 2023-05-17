package com.xxx;

/**
 * 抽象构建者
 * @author Ether
 */
public abstract class Builder {

    //声明Bike类型变量并进行赋值
    protected Bike bike = new Bike();

    public abstract void buildFrame();

    public abstract void buildSeat();

    //构建自行车
    public abstract Bike createBike();

}
