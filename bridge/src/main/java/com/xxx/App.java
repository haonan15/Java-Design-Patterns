package com.xxx;

/**
 * @author Ether
 */
public class App {
    public static void main(String[] args) {
        //创建Mac操作系统
        OperatingSystem system = new Mac(new AviFile());
        system.play("黑豹2");
    }
}
