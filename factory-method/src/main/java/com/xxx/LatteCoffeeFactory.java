package com.xxx;

/**
 * 拿铁咖啡工厂
 * @author Ether
 */
public class LatteCoffeeFactory implements CoffeeFactory{
    @Override
    public Coffee createCoffee() {
        return new LatteCoffee();
    }
}
