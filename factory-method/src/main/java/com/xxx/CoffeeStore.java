package com.xxx;

/**
 * @author Ether
 */
public class CoffeeStore {

    private CoffeeFactory factory;

    public void setFactory(CoffeeFactory factory){
        this.factory = factory;
    }

    public Coffee orderCoffee(){
        Coffee coffee = factory.createCoffee();
        coffee.addSugar();
        coffee.addMilk();
        return coffee;
    }
}
