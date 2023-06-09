package com.xxx;

/**
 * 指挥者类
 * @author Ether
 */
public class Director {

    //声明Builder类型变量
    private Builder builder;

    public Director(Builder builder){
        this.builder = builder;
    }

    //组装自行车
    public Bike construct(){
        builder.buildFrame();
        builder.buildSeat();
        return builder.bike;
    }

}
