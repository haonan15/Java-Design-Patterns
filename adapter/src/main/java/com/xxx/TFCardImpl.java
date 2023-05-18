package com.xxx;

/**
 * 适配者类
 * @author Ether
 */
public class TFCardImpl implements TFCard{

    @Override
    public String readTF() {
        String msg = "read TFCard";
        return msg;
    }

    @Override
    public void writeTF(String msg) {
        System.out.println("TFCard write msg:"+msg);
    }
}
