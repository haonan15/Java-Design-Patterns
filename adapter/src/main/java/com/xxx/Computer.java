package com.xxx;

/**
 * 计算机类
 * @author Ether
 */
public class Computer {

    public String readSD(SDCard sd){
        if (sd == null){
            throw new NullPointerException("SDCard is not null");
        }
        return sd.readSD();
    }

}
