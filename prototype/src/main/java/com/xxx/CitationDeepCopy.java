package com.xxx;

import java.io.*;

/**
 * 奖状类
 * 深拷贝
 * @author Ether
 */
public class CitationDeepCopy  implements Serializable,Cloneable {
    private Student stu;

    public Student getStu() {
        return stu;
    }

    public void setStu(Student stu) {
        this.stu = stu;
    }

    public void show() {
        System.out.println(stu.getName() + "同学被评为三好学生。特发此状！");
    }

    @Override
    public CitationDeepCopy clone() throws CloneNotSupportedException {
        return (CitationDeepCopy) super.clone();
    }

    public CitationDeepCopy copy() throws IOException, ClassNotFoundException {
        // 缓冲输出流
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        // 对象输出流
        ObjectOutputStream outputStream = new ObjectOutputStream(byteArrayOutputStream);
        outputStream.writeObject(this);
        // 从缓冲输出流中获取缓冲输出流
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        // 获取对象输出流
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        return (CitationDeepCopy) objectInputStream.readObject();
    }

}
