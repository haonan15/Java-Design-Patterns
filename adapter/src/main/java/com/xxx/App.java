package com.xxx;

/**
 * @author Ether
 */
public class App {
    public static void main(String[] args) {
        Computer computer = new Computer();
        System.out.println(computer.readSD(new SDCardImpl()));

        //类适配器读取TF
        Computer computer1 = new Computer();
        SDClassAdapterTF sdAdapterTF = new SDClassAdapterTF();
        System.out.println(computer1.readSD(sdAdapterTF));

        //对象适配器读取TF
        Computer computer2 = new Computer();
        SDObjectAdapterTF sdObjectAdapterTF = new SDObjectAdapterTF(new TFCardImpl());
        System.out.println(computer2.readSD(sdObjectAdapterTF));
    }
}
