package com.xxx;

/**
 * 具体SD卡
 * @author Ether
 */
public class SDCardImpl implements SDCard{
    @Override
    public String readSD() {
        String msg = "read SDCard";
        return msg;
    }

    @Override
    public void writeSD(String msg) {
        System.out.println("SDCard write msg:"+msg);
    }
}
