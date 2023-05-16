package com.xxx;

/**
 * 奖状类
 * 浅拷贝
 * @author Ether
 */
public class CitationShallowCopy implements Cloneable {
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
    public CitationShallowCopy clone() throws CloneNotSupportedException {
        return (CitationShallowCopy) super.clone();
    }
}
