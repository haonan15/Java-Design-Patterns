package com.xxx;

/**
 * 炒面类
 * @author Ether
 */
public class FriedNoodles extends FastFood{

    public FriedNoodles(){
        super(12,"炒面");
    }

    @Override
    public float cost() {
        return getPrice();
    }
}
