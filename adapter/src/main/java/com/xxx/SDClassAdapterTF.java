package com.xxx;

/**
 * 类适配器
 * @author Ether
 */
public class SDClassAdapterTF extends TFCardImpl implements SDCard{


    @Override
    public String readSD() {
        System.out.println("adapter read tf card");
        return readTF();
    }

    @Override
    public void writeSD(String msg) {
        System.out.println("adapter write tf card");
        writeTF(msg);
    }
}
