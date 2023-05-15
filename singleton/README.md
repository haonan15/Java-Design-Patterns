## 单例模式

### 概念

单例模式（Singleton Pattern）是 Java 中最简单的设计模式之一。这种类型的设计模式属于创建型模式，它提供了一种创建对象的最佳方式。

这种模式涉及到一个单一的类，该类负责创建自己的对象，同时确保只有单个对象被创建。这个类提供了一种访问其唯一的对象的方式，可以直接访问，不需要实例化该类的对象。

### 结构

单例模式的主要有以下角色：

* 单例类：只能创建一个实例的类
* 访问类：使用单例类

![img](https://cloud-image-host.oss-cn-beijing.aliyuncs.com/img/202305152252836.gif)

饿汉式：类加载就会导致该单实例对象被创建

懒汉式：类加载不会导致该单实例对象被创建，而是首次使用该对象时才会创建

### 实现

#### 饿汉式

> 类加载就会导致该单实例对象被创建

1. **饿汉式      实现方式：静态变量创建类的对象**

   ```java
   /**
    * 静态变量创建类的对象
    * @author Ether
    */
   public class EagerlyInitializedSingleton {
   
       // 私有构造方法
       private EagerlyInitializedSingleton(){}
   
       // 在本类中创建本类对象
       private static EagerlyInitializedSingleton instance = new EagerlyInitializedSingleton();
   
       // 提供一个公共访问方式，让外界获取该对象
       public static EagerlyInitializedSingleton getInstance(){
           return instance;
       }
   }
   ```

2. **饿汉式      实现方式：枚举类**

   ```java
   /**
    * 饿汉式
    * 枚举类 线程安全（极力推荐）
    * @author Ether
    */
   public enum EnumSingleton {
       INSTANCE;
   }
   ```

#### 懒汉式

> 类加载不会导致该单实例对象被创建，而是首次使用该对象时才会创建

1. **方式一：线程不安全**

   ```java
   /**
    * 懒汉式
    * 线程不安全
    * @author Ether
    */
   public class LazilyInitializedSingleton {
   
       // 私有构造方法
       private LazilyInitializedSingleton(){}
   
       // 声明本类对象
       private static LazilyInitializedSingleton instance;
   
       // 提供静态方法获取并创建对象
       //
       public static LazilyInitializedSingleton getInstance(){
           // 判断instance是否为空，为空则说明还没有创建该类的对象
           if(instance == null){
               // 若线程1进来后等待，CPU执行权给线程2，则线程2也会进入并创建不同的对象实例
               instance = new LazilyInitializedSingleton();
           }
           return instance;
       }
   }
   ```

2. **方式二：线程安全**

   ```java
   /**
    * 懒汉式
    * 线程安全
    * @author Ether
    */
   public class ThreadSafeLazyLoadedSingleton {
   
       // 私有构造方法
       private ThreadSafeLazyLoadedSingleton(){}
   
       // 声明本类对象
       private static ThreadSafeLazyLoadedSingleton instance;
   
       public static synchronized ThreadSafeLazyLoadedSingleton getInstance(){
           // 判断instance是否为空，为空则说明还没有创建该类的对象
           if(instance == null){
               instance = new ThreadSafeLazyLoadedSingleton();
           }
           return instance;
       }
   }
   ```

3. **方式三：双重检查锁**

   ```java
   /**
    * 双重检查锁
    * 线程安全 多线程情况下可能会出现空指针问题，需要使用volatile
    * @author Ether
    */
   public class ThreadSafeDoubleCheckLockSingleton {
   
       //私有构造方法
       private ThreadSafeDoubleCheckLockSingleton(){}
   
       // 声明当前类的变量
       private static ThreadSafeDoubleCheckLockSingleton instance;
   
       // 对外提供公共访问方式
       public static ThreadSafeDoubleCheckLockSingleton getInstance(){
           //
           if (instance == null){
               synchronized (ThreadSafeDoubleCheckLockSingleton.class){
                   if (instance == null) {
                       instance = new ThreadSafeDoubleCheckLockSingleton();
                   }
               }
           }
           return instance;
       }
   }
   ```

   **优点**：在实例变量加上了volatile关键词修饰，保证可见性与有序性；双重判断加锁

4. **静态内部类**

   ```java
   /**
    * 懒汉式
    * 静态内部类 线程安全
    * @author Ether
    */
   public class InitializingOnDemandHolderIdiom {
   
       //私有构造方法
       private InitializingOnDemandHolderIdiom(){}
   
       // 定义静态内部类
       private static class SingletonHolder {
           //保证被实例化一次
           private static final InitializingOnDemandHolderIdiom INSTANCE = new InitializingOnDemandHolderIdiom();
       }
       // 提供外部访问方法
       public static InitializingOnDemandHolderIdiom getInstance(){
           return SingletonHolder.INSTANCE;
       }
   }
   ```

5. **静态内部类——解决反序列化破坏单例模式**

   ```java
   import java.io.Serializable;
   
   /**
    * 解决反序列化破坏单例模式
    * @author Ether
    */
   public class SolveDeserializableSingleton implements Serializable {
   
       //私有构造
       private SolveDeserializableSingleton(){}
   
       // 静态内部类
       private static class  SingletonHolder{
           private static final SolveDeserializableSingleton INSTANCE = new SolveDeserializableSingleton();
       }
   
       public static SolveDeserializableSingleton getInstance(){
           return SingletonHolder.INSTANCE;
       }
       // 当进行反序列化时，会自动调用该方法，将该方法返回值直接返回
       public Object readResolve(){
           return SingletonHolder.INSTANCE;
       }
   }
   ```

6. 静态内部类——解决反射破坏单例模式

   ```java
   /**
    * 解决反射破坏单例模式
    * @author Ether
    */
   public class SolveReflectSingleton {
   
       private static boolean flag = false;
   
       // 私有构造方法
       private SolveReflectSingleton(){
   
           //多线程环境
           synchronized (SolveReflectSingleton.class) {
               // 判断flag值是否是true，为true则说明非第一次访问，为false则为第一次访问
               if (flag) {
                   throw new RuntimeException("不能创建多个对象");
               }
               flag = true;
           }
       }
   
       private static class SingletonHolder{
           private static final SolveReflectSingleton INSTANCE = new SolveReflectSingleton();
       }
   
       public static SolveReflectSingleton getInstance(){
           return SolveReflectSingleton.SingletonHolder.INSTANCE;
       }
   }
   ```

### 使用场景

- [java.lang.Runtime#getRuntime()](http://docs.oracle.com/javase/8/docs/api/java/lang/Runtime.html#getRuntime())

  ```java
  public class Runtime {
      private static Runtime currentRuntime = new Runtime();
  
      /**
       * Returns the runtime object associated with the current Java application.
       * Most of the methods of class <code>Runtime</code> are instance
       * methods and must be invoked with respect to the current runtime object.
       *
       * @return  the <code>Runtime</code> object associated with the current
       *          Java application.
       */
      public static Runtime getRuntime() {
          return currentRuntime;
      }
  
      /** Don't let anyone else instantiate this class */
      private Runtime() {}
      ...
  }
  ```

  