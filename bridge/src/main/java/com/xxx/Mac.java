package com.xxx;

/**
 * Mac操作系统，扩展抽象化角色
 * @author Ether
 */
public class Mac extends OperatingSystem{

    public Mac(VideoFile videoFile) {
        super(videoFile);
    }

    @Override
    public void play(String fileName) {
        videoFile.decode(fileName);
    }
}
