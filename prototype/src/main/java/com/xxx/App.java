package com.xxx;

/**
 * 测试
 * @author Ether
 */
public class App {
    public static void main(String[] args) throws Exception{
        //创建奖状对象
        Citation citation = new Citation();
        //克隆奖状对象
        Citation clone = citation.clone();

        citation.setName("张三");
        clone.setName("李四");

        //show展示
        citation.show();
        clone.show();

        //浅拷贝
        //创建原型对象
        CitationShallowCopy citationShallowCopy = new CitationShallowCopy();

        //创建张三学生
        Student student1 = new Student();
        student1.setName("张三");
        citationShallowCopy.setStu(student1);

        //克隆奖状对象
        CitationShallowCopy shallowCopy = citationShallowCopy.clone();
        shallowCopy.getStu().setName("李四");

        //show展示
        citationShallowCopy.show();
        shallowCopy.show();
        System.out.println(citationShallowCopy.getStu() == shallowCopy.getStu());   //true

        //深拷贝
        //创建原型对象
        CitationDeepCopy citationDeepCopy = new CitationDeepCopy();

        //创建张三学生
        Student student2 = new Student();
        student2.setName("王五");
        citationDeepCopy.setStu(student2);

        //克隆奖状对象，这里使用自定义的对象输出流方法
        CitationDeepCopy deepCopy = citationDeepCopy.copy();
        deepCopy.getStu().setName("李四");

        //show展示
        citationDeepCopy.show();
        deepCopy.show();
        System.out.println(citationDeepCopy.getStu() == deepCopy.getStu()); //false
    }
}
