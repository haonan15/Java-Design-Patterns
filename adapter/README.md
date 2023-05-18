## 适配器模式

### 概念

将一个类的接口转换成客户希望的另外一个接口，使得原本由于接口不兼容而不能一起工作的那些类能一起工作。

适配器模式分为类适配器模式和对象适配器模式，前者类之间的耦合度比后者高，且要求程序员了解现有组件库中的相关组件的内部结构，所以应用相对较少些。

### 结构

适配器模式（Adapter）包含以下主要角色：

* 目标（Target）接口：当前系统业务所期待的接口，它可以是抽象类或接口。
* 适配者（Adaptee）类：它是被访问和适配的现存组件库中的组件接口。
* 适配器（Adapter）类：它是一个转换器，通过继承或引用适配者的对象，把适配者接口转换成目标接口，让客户按目标接口的格式访问适配者。

### 类适配器模式

> 实现方式：定义一个适配器类来实现当前系统的业务接口，同时又继承现有组件库中已经存在的组件。

现有一台电脑只能读取SD卡，而要读取TF卡中的内容的话就需要使用到适配器模式。创建一个读卡器，将TF卡中的内容读取出来。

![image-20230517234703943](https://cloud-image-host.oss-cn-beijing.aliyuncs.com/img/202305172347044.png)

**目标接口**

```java
/**
 * 目标接口
 * @author Ether
 */
public interface SDCard {

    public String readSD();

    public void writeSD(String msg);
}
```

**目标接口实现类**

```java
/**
 * 具体SD卡
 * @author Ether
 */
public class SDCardImpl implements SDCard{
    @Override
    public String readSD() {
        String msg = "read SDCard";
        return msg;
    }

    @Override
    public void writeSD(String msg) {
        System.out.println("SDCard write msg:"+msg);
    }
}
```

**适配者**

```java
/**
 * 适配者接口
 * @author Ether
 */
public interface TFCard {

    //从TF卡中读取数据
    String readTF();
    //往TF卡写数据
    void writeTF(String msg);
}
```

**适配者实现类**

```java
/**
 * 适配者类
 * @author Ether
 */
public class TFCardImpl implements TFCard{

    @Override
    public String readTF() {
        String msg = "read TFCard";
        return msg;
    }

    @Override
    public void writeTF(String msg) {
        System.out.println("TFCard write msg:"+msg);
    }
}
```

**主调用类**

```java
/**
 * 计算机类
 * @author Ether
 */
public class Computer {

    public String readSD(SDCard sd){
        if (sd == null){
            throw new NullPointerException("SDCard is not null");
        }
        return sd.readSD();
    }

}
```

**测试**

```java
/**
 * @author Ether
 */
public class App {
    public static void main(String[] args) {
        Computer computer = new Computer();
        System.out.println(computer.readSD(new SDCardImpl()));

        //适配器读取TF
        Computer computer1 = new Computer();
        SDAdapterTF sdAdapterTF = new SDAdapterTF();
        System.out.println(computer1.readSD(sdAdapterTF));
    }
}
```

类适配器模式违背了合成复用原则。类适配器是客户类有一个接口规范的情况下可用，反之不可用。

### 对象适配器模式

> 实现方式：对象适配器模式可釆用将现有组件库中已经实现的组件引入适配器类中，该类同时实现当前系统的业务接口。

![image-20230518152324682](https://cloud-image-host.oss-cn-beijing.aliyuncs.com/img/202305181523784.png)

**适配器**

```java
/**
 * 对象适配器
 * @author Ether
 */
public class SDObjectAdapterTF implements SDCard{

    private TFCard tfCard;

    public SDObjectAdapterTF(TFCard tfCard){
        this.tfCard = tfCard;
    }

    @Override
    public String readSD() {
        System.out.println("adapter read tf card");
        return tfCard.readTF();
    }

    @Override
    public void writeSD(String msg) {
        System.out.println("adapter write tf card");
        tfCard.writeTF(msg);
    }
}
```

>  注意：还有一个适配器模式是接口适配器模式。当不希望实现一个接口中所有的方法时，可以创建一个抽象类Adapter ，实现所有方法。而此时我们只需要继承该抽象类即可。

### 使用场景

* 以前开发的系统存在满足新系统功能需求的类，但其接口同新系统的接口不一致。
* 使用第三方提供的组件，但组件接口定义和自己要求的接口定义不同。