package com.xxx;

/**
 * 具体实现化角色，rmvb视频文件
 * @author Ether
 */
public class RmvbFile implements VideoFile{
    @Override
    public void decode(String fileName) {
        System.out.println("rmvb视频文件:" + fileName);
    }
}
