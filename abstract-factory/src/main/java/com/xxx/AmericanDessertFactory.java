package com.xxx;

/**
 * 美式甜品工厂
 * @author Ether
 */
public class AmericanDessertFactory implements DessertFactory{


    @Override
    public Coffee createCoffee() {
        return new AmericanCoffee();
    }

    @Override
    public Dessert createDessert() {
        return new MatchaMousse();
    }
}
