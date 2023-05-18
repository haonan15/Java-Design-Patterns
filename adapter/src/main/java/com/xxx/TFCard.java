package com.xxx;

/**
 * 适配者接口
 * @author Ether
 */
public interface TFCard {

    //从TF卡中读取数据
    String readTF();
    //往TF卡写数据
    void writeTF(String msg);
}
