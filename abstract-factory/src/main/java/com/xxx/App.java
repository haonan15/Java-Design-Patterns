package com.xxx;

/**
 * 测试
 * @author Ether
 */
public class App {
    public static void main(String[] args) {
        //意式甜品
        ItalyDessertFactory factory  = new ItalyDessertFactory();

        Coffee coffee = factory.createCoffee();
        Dessert dessert = factory.createDessert();

        coffee.addMilk();
        coffee.addSugar();
        System.out.println(coffee.getName());   //拿铁咖啡

        dessert.show();     //提拉米苏
    }
}
