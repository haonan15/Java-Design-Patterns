package com.xxx;

/**
 * 测试类
 * @author Ether
 */
public class App {
    public static void main(String[] args) {
        // 创建咖啡店对象
        CoffeeStore coffeeStore = new CoffeeStore();
        // 创建工厂对象
        CoffeeFactory factory = new AmericanCoffeeFactory();
        coffeeStore.setFactory(factory);
        //点咖啡
        Coffee coffee = coffeeStore.orderCoffee();
        System.out.println(coffee.getName());   //美式咖啡
    }
}
