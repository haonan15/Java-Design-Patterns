package com.xxx;

/**
 * 操作系统类，抽象角色
 * @author Ether
 */
public abstract class OperatingSystem {

    protected VideoFile videoFile;

    public OperatingSystem(VideoFile videoFile){
        this.videoFile = videoFile;
    }

    public abstract void play(String fileName);

}
