## 外观模式

### 概念

又名门面模式，是一种通过为多个复杂的子系统提供一个一致的接口，而使这些子系统更加容易被访问的模式。该模式对外有一个统一接口，外部应用程序不用关心内部子系统的具体的细节，这样会大大降低应用程序的复杂度，提高了程序的可维护性。

### 结构

外观（Facade）模式包含以下主要角色：

* 外观（Facade）角色：为多个子系统对外提供一个共同的接口。
* 子系统（Sub System）角色：实现系统的部分功能，客户可以通过外观角色访问它。

### 实现

智能家电控制：晚上每次都需要打开灯、打开电视、打开空调；睡觉时关闭灯、关闭电视、关闭空调；操作起来都比较麻烦。所以可以实现一个智能家电控制系统，通过语音直接控制这些智能家电的开启和关闭。类图如下：

![image-20230521155413957](https://cloud-image-host.oss-cn-beijing.aliyuncs.com/img/202305211554069.png)

**外观角色**

```java
/**
 * 外观类，用户主要和该类对象进行交互
 * @author Ether
 */
public class SmartApplicationFacade {

    private Light light;
    private TV tv;
    private AirCondition airCondition;

    public SmartApplicationFacade() {
        light = new Light();
        tv = new TV();
        airCondition = new AirCondition();
    }

    public void say(String message){
        if (message.contains("打开")){
            on();
        }else if (message.contains("关闭")){
            off();
        }else {
            System.out.println("不太清楚要做什么");
        }
    }

    public void on(){
        light.on();
        tv.on();
        airCondition.on();
    }

    public void off(){
        light.off();
        tv.off();
        airCondition.off();
    }

}
```

**子系统角色**

```java
/**
 * 电灯
 * @author Ether
 */
public class Light {

    public void on(){
        System.out.println("打开电灯");
    }
    public void off(){
        System.out.println("关闭电灯");
    }
}
```

```java
/**
 * 电视类
 * @author Ether
 */
public class TV {
    public void on(){
        System.out.println("打开电视");
    }
    public void off(){
        System.out.println("关闭电视");
    }
}
```

```java
/**
 * 空调
 * @author Ether
 */
public class AirCondition {
    public void on(){
        System.out.println("打开空调");
    }
    public void off(){
        System.out.println("关闭空调");
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
        SmartApplicationFacade facade = new SmartApplicationFacade();
        facade.say("打开家电");
        facade.say("关闭家电");
    }
}
```

### 优缺点

#### 优点

* 降低了子系统与客户端之间的耦合度，使得子系统的变化不会影响调用它的客户类。
* 对客户屏蔽了子系统组件，减少了客户处理的对象数目，并使得子系统使用起来更加容易。

#### 缺点

- 不符合开闭原则，修改很麻烦

### 使用场景

* 对分层结构系统构建时，使用外观模式定义子系统中每层的入口点可以简化子系统之间的依赖关系。
* 当一个复杂系统的子系统很多时，外观模式可以为系统设计一个简单的接口供外界访问。
* 当客户端与多个子系统之间存在很大的联系时，引入外观模式可将它们分离，从而提高子系统的独立性和可移植性。