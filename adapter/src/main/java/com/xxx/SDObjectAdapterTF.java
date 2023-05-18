package com.xxx;

/**
 * 对象适配器
 * @author Ether
 */
public class SDObjectAdapterTF implements SDCard{

    private TFCard tfCard;

    public SDObjectAdapterTF(TFCard tfCard){
        this.tfCard = tfCard;
    }

    @Override
    public String readSD() {
        System.out.println("adapter read tf card");
        return tfCard.readTF();
    }

    @Override
    public void writeSD(String msg) {
        System.out.println("adapter write tf card");
        tfCard.writeTF(msg);
    }
}
