package com.xxx;

/**
 * 美式咖啡工厂
 * @author Ether
 */
public class AmericanCoffeeFactory implements CoffeeFactory{
    @Override
    public Coffee createCoffee() {
        return new AmericanCoffee();
    }
}
