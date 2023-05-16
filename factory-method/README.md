## 工厂方法模式

为创建一个对象定义一个接口，让子类决定实例化哪个类。

工厂方法允许类将实例化延迟到子类。

### 结构

工厂方法模式的主要角色：

* 抽象工厂（Abstract Factory）：提供了创建产品的接口，调用者通过它访问具体工厂的工厂方法来创建产品。
* 具体工厂（ConcreteFactory）：主要是实现抽象工厂中的抽象方法，完成具体产品的创建。
* 抽象产品（Product）：定义了产品的规范，描述了产品的主要特性和功能。
* 具体产品（ConcreteProduct）：实现了抽象产品角色所定义的接口，由具体工厂来创建，它同具体工厂之间一一对应。

### 实现

![image-20230516104737196](https://cloud-image-host.oss-cn-beijing.aliyuncs.com/img/202305161047263.png)

**抽象工厂**

```java
/**
 * 咖啡工厂类
 * @author Ether
 */
public interface CoffeeFactory {

    // 创建咖啡对象方法
    Coffee createCoffee();
}
```

**具体工厂**

```java
/**
 * 美式咖啡工厂
 * @author Ether
 */
public class AmericanCoffeeFactory implements CoffeeFactory{
    @Override
    public Coffee createCoffee() {
        return new AmericanCoffee();
    }
}
```

```java
/**
 * 拿铁咖啡工厂
 * @author Ether
 */
public class LatteCoffeeFactory implements CoffeeFactory{
    @Override
    public Coffee createCoffee() {
        return new LatteCoffee();
    }
}
```

**抽象产品**

```java
/**
 * 咖啡类
 * @author Ether
 */
public abstract class Coffee {

    public abstract String getName();

    // 加糖
    public void addSugar(){
        System.out.println("加糖");
    }

    // 加奶
    public void addMilk(){
        System.out.println("加奶");
    }

}
```

**具体产品**

```java
/**
 * 美式咖啡
 * @author Ether
 */
public class AmericanCoffee extends Coffee{
    @Override
    public String getName() {
        return "美式咖啡";
    }
}
```

```java
/**
 * 拿铁咖啡
 * @author Ether
 */
public class LatteCoffee extends Coffee{
    @Override
    public String getName() {
        return "拿铁咖啡";
    }
}
```

**测试类**

```java
/**
 * 测试类
 * @author Ether
 */
public class App {
    public static void main(String[] args) {
        // 创建咖啡店对象
        CoffeeStore coffeeStore = new CoffeeStore();
        // 创建工厂对象
        CoffeeFactory factory = new AmericanCoffeeFactory();
        coffeeStore.setFactory(factory);
        //点咖啡
        Coffee coffee = coffeeStore.orderCoffee();
        System.out.println(coffee.getName());   //美式咖啡
    }
}
```



若需再添加产品种类，只需要添加一个新的咖啡工厂的子实现类和产品实体即可（符合开闭原则，对扩展开放，对修改关闭）

### 优缺点

#### 优点

- 用户只需要知道具体工厂的名称就可得到所要的产品，无须知道产品的具体创建过程；
- 在系统增加新的产品时只需要添加具体产品类和对应的具体工厂类，无须对原工厂进行任何修改，满足开闭原则；

#### 缺点

* 每增加一个产品就要增加一个具体产品类和一个对应的具体工厂类，这增加了系统的复杂度。

### 使用场景

1. DateForamt类中的getInstance()方法使用的是工厂模式；

2. Calendar类中的getInstance()方法使用的是工厂模式；