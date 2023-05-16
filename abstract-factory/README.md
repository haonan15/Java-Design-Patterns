## 抽象工厂模式

### 概念

是一种为访问类提供一个创建一组相关或相互依赖对象的接口，且访问类无须指定所要产品的具体类就能得到同族的不同等级的产品的模式结构。

抽象工厂模式是工厂方法模式的升级版本，工厂方法模式只生产一个等级的产品，而抽象工厂模式可生产多个等级的产品。

### 结构

抽象工厂模式的主要角色如下：

* 抽象工厂（Abstract Factory）：提供了创建产品的接口，它包含多个创建产品的方法，可以创建多个不同等级的产品。
* 具体工厂（Concrete Factory）：主要是实现抽象工厂中的多个抽象方法，完成具体产品的创建。
* 抽象产品（Product）：定义了产品的规范，描述了产品的主要特性和功能，抽象工厂模式有多个抽象产品。
* 具体产品（ConcreteProduct）：实现了抽象产品角色所定义的接口，由具体工厂来创建，它 同具体工厂之间是多对一的关系。

### 实现

![image-20230516144647680](https://cloud-image-host.oss-cn-beijing.aliyuncs.com/img/202305161446746.png)

**抽象工厂**

```java
/**
 * 甜品工厂
 * @author Ether
 */
public interface DessertFactory {

    //生产咖啡
    Coffee createCoffee();

    //生产甜品
    Dessert createDessert();

}
```

**具体工厂**

```java
/**
 * 美式甜品工厂
 * @author Ether
 */
public class AmericanDessertFactory implements DessertFactory{


    @Override
    public Coffee createCoffee() {
        return new AmericanCoffee();
    }

    @Override
    public Dessert createDessert() {
        return new MatchaMousse();
    }
}
```

```java
/**
 * 意式甜品工厂
 * @author Ether
 */
public class ItalyDessertFactory implements DessertFactory{
    @Override
    public Coffee createCoffee() {
        return new LatteCoffee();
    }

    @Override
    public Dessert createDessert() {
        return new Tiramisu();
    }
}
```

**抽象产品**

```java
/**
 * 抽象咖啡类
 * @author Ether
 */
public abstract class Coffee {

    public abstract String getName();

    public void addMilk(){
        System.out.println("加奶");
    }

    public void addSugar(){
        System.out.println("加糖");
    }

}
```

```java
/**
 * 甜品抽象类
 * @author Ether
 */
public abstract class Dessert {

    public abstract void show();

}
```

**具体产品**

```java
/**
 * 提拉米苏类
 * @author Ether
 */
public class Tiramisu extends Dessert{
    @Override
    public void show() {
        System.out.println("提拉米苏");
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

如果要加同一个产品族的话，只需要再加一个对应的工厂类即可，不需要修改其他的类。

### 优缺点

#### 优点

当一个产品族中的多个对象被设计成一起工作时，它能保证客户端始终只使用同一个产品族中的对象。

#### 缺点

当产品族中需要增加一个新的产品时，所有的工厂类都需要进行修改。

### 使用场景

* 当需要创建的对象是一系列相互关联或相互依赖的产品族时，如电器工厂中的电视机、洗衣机、空调等。

* 系统中有多个产品族，但每次只使用其中的某一族产品。如有人只喜欢穿某一个品牌的衣服和鞋。

* 系统中提供了产品的类库，且所有产品的接口相同，客户端不依赖产品实例的创建细节和内部结构。

如：输入法换皮肤，一整套一起换。生成不同操作系统的程序。

Collection.iterator方法

![image-20230516151137424](https://cloud-image-host.oss-cn-beijing.aliyuncs.com/img/202305161511464.png)

Collection接口是抽象工厂类，ArrayList是具体的工厂类；Iterator接口是抽象商品类，ArrayList类中的Iter内部类是具体的商品类。在具体的工厂类中iterator()方法创建具体的商品类的对象。