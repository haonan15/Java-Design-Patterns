package com.xxx;

/**
 * 外观类，用户主要和该类对象进行交互
 * @author Ether
 */
public class SmartApplicationFacade {

    private Light light;
    private TV tv;
    private AirCondition airCondition;

    public SmartApplicationFacade() {
        light = new Light();
        tv = new TV();
        airCondition = new AirCondition();
    }

    public void say(String message){
        if (message.contains("打开")){
            on();
        }else if (message.contains("关闭")){
            off();
        }else {
            System.out.println("不太清楚要做什么");
        }
    }

    public void on(){
        light.on();
        tv.on();
        airCondition.on();
    }

    public void off(){
        light.off();
        tv.off();
        airCondition.off();
    }

}
