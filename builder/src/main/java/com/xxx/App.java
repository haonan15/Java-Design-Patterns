package com.xxx;

/**
 * @author Ether
 */
public class App {
    public static void main(String[] args) {
        //创建指挥者对象
        Director director = new Director(new MobileBuilder());
        //让指挥者组装自行车
        Bike bike = director.construct();
        System.out.println(bike.getFrame()+'\n'+bike.getSeat());


        //测试手机类
        Phone phone = new Phone.Builder()
                .cpu("Intel")
                .screen("三星屏幕")
                .memory("金士顿内存条")
                .mainboard("华硕主板")
                .build();
        System.out.println(phone);  //Phone{cpu='Intel', screen='三星屏幕', memory='金士顿内存条', mainboard='华硕主板'}
    }
}
