package com.xxx;

/**
 * 甜品工厂
 * @author Ether
 */
public interface DessertFactory {

    //生产咖啡
    Coffee createCoffee();

    //生产甜品
    Dessert createDessert();

}
