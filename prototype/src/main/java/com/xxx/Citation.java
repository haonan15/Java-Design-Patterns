package com.xxx;

/**
 * 三好学生奖状类
 * @author Ether
 */
public class Citation implements Cloneable{

    //奖状上的名称
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void show(){
        System.out.println(name + "被评为三好学生，特发此状！");
    }

    @Override
    public Citation clone() throws CloneNotSupportedException {

        return (Citation) super.clone();

    }
}
