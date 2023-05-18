package com.xxx;

/**
 * AVI视频角色，实现化角色
 * @author Ether
 */
public class AviFile implements VideoFile{
    @Override
    public void decode(String fileName) {
        System.out.println("avi视频文件:" + fileName);
    }
}
