## 原型模式

### 概念

用一个已经创建的实例作为原型，通过复制该原型对象来创建一个和原型对象相同的新对象。

### 结构

原型模式包含如下角色：

* 抽象原型类：规定了具体原型对象必须实现的的 clone() 方法。
* 具体原型类：实现抽象原型类的 clone() 方法，它是可被复制的对象。
* 访问类：使用具体原型类中的 clone() 方法来复制新的对象。

### 浅拷贝实现

> 浅拷贝：创建一个新对象，新对象的属性和原来对象完全相同，对于非基本类型属性，仍指向原有属性所指向的对象的内存地址。

**用原型模式生成“三好学生”奖状**

同一学校的“三好学生”奖状除了获奖人姓名不同，其他都相同，可以使用原型模式复制多个“三好学生”奖状出来，然后在修改奖状上的名字即可。

**原型实体类**

```java
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
```

**测试**

```java
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
    }
}
```

**原型实体类**

```java
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
```

**测试**

```java
/**
 * 测试
 * @author Ether
 */
public class App {
    public static void main(String[] args) throws Exception{
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
    }
}
```

### 深拷贝实现

>  深拷贝：创建一个新对象，属性中引用的其他对象也会被克隆，不再指向原有对象地址。

**原型实体类**

```java
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
```

**学生类**

```java
import java.io.Serializable;

/**
 * 学生类
 * @author Ether
 */
public class Student implements Serializable {
    private String name;
    private String address;

    public Student(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
```

**测试**

```java
/**
 * 测试
 * @author Ether
 */
public class App {
    public static void main(String[] args) throws Exception{
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
```

### 使用场景

* 对象的创建非常复杂，可以使用原型模式快捷的创建对象。
* 性能和安全要求比较高。