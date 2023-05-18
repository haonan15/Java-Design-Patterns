package com.xxx;

/**
 * 扩展抽象化角色，Windows操作系统
 * @author Ether
 */
public class Windows extends OperatingSystem{

    public Windows(VideoFile videoFile) {
        super(videoFile);
    }

    @Override
    public void play(String fileName) {
        videoFile.decode(fileName);
    }
}
