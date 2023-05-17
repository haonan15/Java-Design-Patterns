## 代理模式

### 概念

由于某些原因需要给某对象提供一个代理以控制对该对象的访问。这时，访问对象不适合或者不能直接引用目标对象，代理对象作为访问对象和目标对象之间的中介。

Java中的代理按照代理类生成时机不同又分为静态代理和动态代理。静态代理代理类在编译期就生成，而动态代理代理类则是在Java运行时动态生成。动态代理又有JDK代理和CGLib代理两种。

### 结构

代理（Proxy）模式分为三种角色：

* 抽象主题（Subject）类： 通过接口或抽象类声明真实主题和代理对象实现的业务方法。
* 真实主题（Real Subject）类： 实现了抽象主题中的具体业务，是代理对象所代表的真实对象，是最终要引用的对象。
* 代理（Proxy）类 ： 提供了与真实主题相同的接口，其内部含有对真实主题的引用，它可以访问、控制或扩展真实主题的功能。

### 静态代理

如果要买火车票的话，需要去火车站买票，坐车到火车站，排队等一系列的操作，显然比较麻烦。而火车站在多个地方都有代售点，我们去代售点买票就方便很多了。这个例子就是典型的代理模式，火车站是目标对象，代售点是代理对象。

![image-20230517233603479](https://cloud-image-host.oss-cn-beijing.aliyuncs.com/img/202305172336571.png)

**抽象主题**

```java
/**
 * 卖火车票接口
 * @author Ether
 */
public interface SellTickets {

    void sell();

}
```

**真实主题**

```java
/**
 * 火车站
 * @author Ether
 */
public class TrainStation implements SellTickets{
    @Override
    public void sell() {
        System.out.println("火车站卖票");
    }
}
```

**代理类**

```java
/**
 * 代售点
 * @author Ether
 */
public class ProxyPoint implements SellTickets{

    //声明火车站对象
    private TrainStation station = new TrainStation();

    @Override
    public void sell() {
        System.out.println("进行收费");
        station.sell();
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
        //静态代理
		ProxyPoint point = new ProxyPoint();
        point.sell();
    }
}
```

### 动态代理

#### JDK动态代理

**代理工厂**

```java
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 获取代理对象的工厂类
 * @author Ether
 */
public class ProxyFactory {

    //声明目标对象
    private TrainStation station = new TrainStation();

    public SellTickets getProxyObject(){
        /**
         * ClassLoader loader：  类加载器，用于加载代理类
         * Class<?>[] interfaces：   代理类实现接口的字节码对象
         * InvocationHandler：    代理对象调用处理
         */
        SellTickets proxyObject = (SellTickets)Proxy.newProxyInstance(
                station.getClass().getClassLoader(),
                station.getClass().getInterfaces(),
                new InvocationHandler() {

                    /**
                     *
                     * @param proxy 代理对象
                     * @param method 对接口中方法进行封装的代理对象
                     * @param args 调用方法的实际参数
                     * @return 方法的返回值
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        // System.out.println("Invoke方法执行");
                        System.out.println("代售点收取服务费（JDK动态代理）");
                        //调用目标方法
                        Object invoke = method.invoke(station, args);
                        return invoke;
                    }
                }
        );

        return proxyObject;
    }

}
```

**代理类**

```java
package com.sun.proxy;

import com.xxx.SellTickets;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.UndeclaredThrowableException;

public final class $Proxy0 extends Proxy implements SellTickets {
    private static Method m1;
    private static Method m2;
    private static Method m3;
    private static Method m0;

    public $Proxy0(InvocationHandler invocationHandler) {
        super(invocationHandler);
    }

    static {
        try {
            m1 = Class.forName("java.lang.Object").getMethod("equals", Class.forName("java.lang.Object"));
            m2 = Class.forName("java.lang.Object").getMethod("toString", new Class[0]);
            m3 = Class.forName("com.xxx.SellTickets").getMethod("sell", new Class[0]);
            m0 = Class.forName("java.lang.Object").getMethod("hashCode", new Class[0]);
            return;
        }
        catch (NoSuchMethodException noSuchMethodException) {
            throw new NoSuchMethodError(noSuchMethodException.getMessage());
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError(classNotFoundException.getMessage());
        }
    }

    public final boolean equals(Object object) {
        try {
            return (Boolean)this.h.invoke(this, m1, new Object[]{object});
        }
        catch (Error | RuntimeException throwable) {
            throw throwable;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    public final String toString() {
        try {
            return (String)this.h.invoke(this, m2, null);
        }
        catch (Error | RuntimeException throwable) {
            throw throwable;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    public final int hashCode() {
        try {
            return (Integer)this.h.invoke(this, m0, null);
        }
        catch (Error | RuntimeException throwable) {
            throw throwable;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    public final void sell() {
        try {
            this.h.invoke(this, m3, null);
            return;
        }
        catch (Error | RuntimeException throwable) {
            throw throwable;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
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
        ProxyPoint point = new ProxyPoint();
        point.sell();

        //获取代理对象
        //创建代理工厂
        ProxyFactory factory = new ProxyFactory();
        //获取代理对象
        SellTickets proxyObject = factory.getProxyObject();
        //调用方法
        proxyObject.sell();

        // System.out.println(proxyObject.getClass());
        // while (true){}
    }
}
```

执行流程如下：

    1. 在测试类中通过代理对象调用sell()方法
    2. 根据多态的特性，执行的是代理类（$Proxy0）中的sell()方法
    3. 代理类（$Proxy0）中的sell()方法中又调用了InvocationHandler接口的子实现类对象的invoke方法
    4. invoke方法通过反射执行了真实对象所属类(TrainStation)中的sell()方法

#### CGLIB动态代理

**代理工厂**

```java
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 代理对象工厂
 * 获取代理对象（cglib）
 * @author Ether
 */
public class CglibProxyFactory implements MethodInterceptor {

    //声明火车站对象
    TrainStation station = new TrainStation();

    public TrainStation getProxyObject(){
        //创建Enhancer对象，类似JDK中的proxy类
        Enhancer enhancer = new Enhancer();

        //设置父类字节码对象
        enhancer.setSuperclass(TrainStation.class);

        //设置回调函数
        enhancer.setCallback(this);
        //创建代理对象
        TrainStation proxyObject = (TrainStation) enhancer.create();
        return proxyObject;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("代售点收取服务费（Cglib动态代理）");

        Object invoke = method.invoke(station, objects);

        return invoke;
    }
}
```

**代理类**

```java
package com.xxx;

import com.xxx.TrainStation;
import java.lang.reflect.Method;
import net.sf.cglib.core.ReflectUtils;
import net.sf.cglib.core.Signature;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Factory;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class TrainStation$$EnhancerByCGLIB$$f3f5c491
extends TrainStation
implements Factory {
    private boolean CGLIB$BOUND;
    private static final ThreadLocal CGLIB$THREAD_CALLBACKS;
    private static final Callback[] CGLIB$STATIC_CALLBACKS;
    private MethodInterceptor CGLIB$CALLBACK_0;
    private static final Method CGLIB$sell$0$Method;
    private static final MethodProxy CGLIB$sell$0$Proxy;
    private static final Object[] CGLIB$emptyArgs;
    private static final Method CGLIB$finalize$1$Method;
    private static final MethodProxy CGLIB$finalize$1$Proxy;
    private static final Method CGLIB$equals$2$Method;
    private static final MethodProxy CGLIB$equals$2$Proxy;
    private static final Method CGLIB$toString$3$Method;
    private static final MethodProxy CGLIB$toString$3$Proxy;
    private static final Method CGLIB$hashCode$4$Method;
    private static final MethodProxy CGLIB$hashCode$4$Proxy;
    private static final Method CGLIB$clone$5$Method;
    private static final MethodProxy CGLIB$clone$5$Proxy;

    public TrainStation$$EnhancerByCGLIB$$f3f5c491() {
        TrainStation$$EnhancerByCGLIB$$f3f5c491 trainStation$$EnhancerByCGLIB$$f3f5c491 = this;
        TrainStation$$EnhancerByCGLIB$$f3f5c491.CGLIB$BIND_CALLBACKS(trainStation$$EnhancerByCGLIB$$f3f5c491);
    }

    static {
        TrainStation$$EnhancerByCGLIB$$f3f5c491.CGLIB$STATICHOOK1();
    }

    protected final void finalize() throws Throwable {
        MethodInterceptor methodInterceptor = this.CGLIB$CALLBACK_0;
        if (methodInterceptor == null) {
            TrainStation$$EnhancerByCGLIB$$f3f5c491.CGLIB$BIND_CALLBACKS(this);
            methodInterceptor = this.CGLIB$CALLBACK_0;
        }
        if (methodInterceptor != null) {
            Object object = methodInterceptor.intercept(this, CGLIB$finalize$1$Method, CGLIB$emptyArgs, CGLIB$finalize$1$Proxy);
            return;
        }
        super.finalize();
    }

    public final boolean equals(Object object) {
        MethodInterceptor methodInterceptor = this.CGLIB$CALLBACK_0;
        if (methodInterceptor == null) {
            TrainStation$$EnhancerByCGLIB$$f3f5c491.CGLIB$BIND_CALLBACKS(this);
            methodInterceptor = this.CGLIB$CALLBACK_0;
        }
        if (methodInterceptor != null) {
            Object object2 = methodInterceptor.intercept(this, CGLIB$equals$2$Method, new Object[]{object}, CGLIB$equals$2$Proxy);
            return object2 == null ? false : (Boolean)object2;
        }
        return super.equals(object);
    }

    public final String toString() {
        MethodInterceptor methodInterceptor = this.CGLIB$CALLBACK_0;
        if (methodInterceptor == null) {
            TrainStation$$EnhancerByCGLIB$$f3f5c491.CGLIB$BIND_CALLBACKS(this);
            methodInterceptor = this.CGLIB$CALLBACK_0;
        }
        if (methodInterceptor != null) {
            return (String)methodInterceptor.intercept(this, CGLIB$toString$3$Method, CGLIB$emptyArgs, CGLIB$toString$3$Proxy);
        }
        return super.toString();
    }

    public final int hashCode() {
        MethodInterceptor methodInterceptor = this.CGLIB$CALLBACK_0;
        if (methodInterceptor == null) {
            TrainStation$$EnhancerByCGLIB$$f3f5c491.CGLIB$BIND_CALLBACKS(this);
            methodInterceptor = this.CGLIB$CALLBACK_0;
        }
        if (methodInterceptor != null) {
            Object object = methodInterceptor.intercept(this, CGLIB$hashCode$4$Method, CGLIB$emptyArgs, CGLIB$hashCode$4$Proxy);
            return object == null ? 0 : ((Number)object).intValue();
        }
        return super.hashCode();
    }

    protected final Object clone() throws CloneNotSupportedException {
        MethodInterceptor methodInterceptor = this.CGLIB$CALLBACK_0;
        if (methodInterceptor == null) {
            TrainStation$$EnhancerByCGLIB$$f3f5c491.CGLIB$BIND_CALLBACKS(this);
            methodInterceptor = this.CGLIB$CALLBACK_0;
        }
        if (methodInterceptor != null) {
            return methodInterceptor.intercept(this, CGLIB$clone$5$Method, CGLIB$emptyArgs, CGLIB$clone$5$Proxy);
        }
        return super.clone();
    }

    public Object newInstance(Callback callback) {
        TrainStation$$EnhancerByCGLIB$$f3f5c491.CGLIB$SET_THREAD_CALLBACKS(new Callback[]{callback});
        TrainStation$$EnhancerByCGLIB$$f3f5c491 trainStation$$EnhancerByCGLIB$$f3f5c491 = new TrainStation$$EnhancerByCGLIB$$f3f5c491();
        TrainStation$$EnhancerByCGLIB$$f3f5c491.CGLIB$SET_THREAD_CALLBACKS(null);
        return trainStation$$EnhancerByCGLIB$$f3f5c491;
    }

    public Object newInstance(Callback[] callbackArray) {
        TrainStation$$EnhancerByCGLIB$$f3f5c491.CGLIB$SET_THREAD_CALLBACKS(callbackArray);
        TrainStation$$EnhancerByCGLIB$$f3f5c491 trainStation$$EnhancerByCGLIB$$f3f5c491 = new TrainStation$$EnhancerByCGLIB$$f3f5c491();
        TrainStation$$EnhancerByCGLIB$$f3f5c491.CGLIB$SET_THREAD_CALLBACKS(null);
        return trainStation$$EnhancerByCGLIB$$f3f5c491;
    }

    public Object newInstance(Class[] classArray, Object[] objectArray, Callback[] callbackArray) {
        TrainStation$$EnhancerByCGLIB$$f3f5c491 trainStation$$EnhancerByCGLIB$$f3f5c491;
        TrainStation$$EnhancerByCGLIB$$f3f5c491.CGLIB$SET_THREAD_CALLBACKS(callbackArray);
        Class[] classArray2 = classArray;
        switch (classArray.length) {
            case 0: {
                trainStation$$EnhancerByCGLIB$$f3f5c491 = new TrainStation$$EnhancerByCGLIB$$f3f5c491();
                break;
            }
            default: {
                throw new IllegalArgumentException("Constructor not found");
            }
        }
        TrainStation$$EnhancerByCGLIB$$f3f5c491.CGLIB$SET_THREAD_CALLBACKS(null);
        return trainStation$$EnhancerByCGLIB$$f3f5c491;
    }

    public void setCallback(int n, Callback callback) {
        switch (n) {
            case 0: {
                this.CGLIB$CALLBACK_0 = (MethodInterceptor)callback;
                break;
            }
        }
    }

    public final void sell() {
        MethodInterceptor methodInterceptor = this.CGLIB$CALLBACK_0;
        if (methodInterceptor == null) {
            TrainStation$$EnhancerByCGLIB$$f3f5c491.CGLIB$BIND_CALLBACKS(this);
            methodInterceptor = this.CGLIB$CALLBACK_0;
        }
        if (methodInterceptor != null) {
            Object object = methodInterceptor.intercept(this, CGLIB$sell$0$Method, CGLIB$emptyArgs, CGLIB$sell$0$Proxy);
            return;
        }
        super.sell();
    }

    public void setCallbacks(Callback[] callbackArray) {
        Callback[] callbackArray2 = callbackArray;
        TrainStation$$EnhancerByCGLIB$$f3f5c491 trainStation$$EnhancerByCGLIB$$f3f5c491 = this;
        this.CGLIB$CALLBACK_0 = (MethodInterceptor)callbackArray[0];
    }

    public static void CGLIB$SET_STATIC_CALLBACKS(Callback[] callbackArray) {
        CGLIB$STATIC_CALLBACKS = callbackArray;
    }

    public static void CGLIB$SET_THREAD_CALLBACKS(Callback[] callbackArray) {
        CGLIB$THREAD_CALLBACKS.set(callbackArray);
    }

    public Callback[] getCallbacks() {
        TrainStation$$EnhancerByCGLIB$$f3f5c491.CGLIB$BIND_CALLBACKS(this);
        TrainStation$$EnhancerByCGLIB$$f3f5c491 trainStation$$EnhancerByCGLIB$$f3f5c491 = this;
        return new Callback[]{this.CGLIB$CALLBACK_0};
    }

    public Callback getCallback(int n) {
        MethodInterceptor methodInterceptor;
        TrainStation$$EnhancerByCGLIB$$f3f5c491.CGLIB$BIND_CALLBACKS(this);
        switch (n) {
            case 0: {
                methodInterceptor = this.CGLIB$CALLBACK_0;
                break;
            }
            default: {
                methodInterceptor = null;
            }
        }
        return methodInterceptor;
    }

    final void CGLIB$finalize$1() throws Throwable {
        super.finalize();
    }

    final void CGLIB$sell$0() {
        super.sell();
    }

    final boolean CGLIB$equals$2(Object object) {
        return super.equals(object);
    }

    final int CGLIB$hashCode$4() {
        return super.hashCode();
    }

    final String CGLIB$toString$3() {
        return super.toString();
    }

    final Object CGLIB$clone$5() throws CloneNotSupportedException {
        return super.clone();
    }

    public static MethodProxy CGLIB$findMethodProxy(Signature signature) {
        String string = ((Object)signature).toString();
        switch (string.hashCode()) {
            case -1574182249: {
                if (!string.equals("finalize()V")) break;
                return CGLIB$finalize$1$Proxy;
            }
            case -508378822: {
                if (!string.equals("clone()Ljava/lang/Object;")) break;
                return CGLIB$clone$5$Proxy;
            }
            case 1826985398: {
                if (!string.equals("equals(Ljava/lang/Object;)Z")) break;
                return CGLIB$equals$2$Proxy;
            }
            case 1913648695: {
                if (!string.equals("toString()Ljava/lang/String;")) break;
                return CGLIB$toString$3$Proxy;
            }
            case 1978249955: {
                if (!string.equals("sell()V")) break;
                return CGLIB$sell$0$Proxy;
            }
            case 1984935277: {
                if (!string.equals("hashCode()I")) break;
                return CGLIB$hashCode$4$Proxy;
            }
        }
        return null;
    }

    static void CGLIB$STATICHOOK1() {
        CGLIB$THREAD_CALLBACKS = new ThreadLocal();
        CGLIB$emptyArgs = new Object[0];
        Class<?> clazz = Class.forName("com.xxx.TrainStation$$EnhancerByCGLIB$$f3f5c491");
        Class<?> clazz2 = Class.forName("com.xxx.TrainStation");
        CGLIB$sell$0$Method = ReflectUtils.findMethods(new String[]{"sell", "()V"}, clazz2.getDeclaredMethods())[0];
        CGLIB$sell$0$Proxy = MethodProxy.create(clazz2, clazz, "()V", "sell", "CGLIB$sell$0");
        clazz2 = Class.forName("java.lang.Object");
        Method[] methodArray = ReflectUtils.findMethods(new String[]{"finalize", "()V", "equals", "(Ljava/lang/Object;)Z", "toString", "()Ljava/lang/String;", "hashCode", "()I", "clone", "()Ljava/lang/Object;"}, clazz2.getDeclaredMethods());
        CGLIB$finalize$1$Method = methodArray[0];
        CGLIB$finalize$1$Proxy = MethodProxy.create(clazz2, clazz, "()V", "finalize", "CGLIB$finalize$1");
        CGLIB$equals$2$Method = methodArray[1];
        CGLIB$equals$2$Proxy = MethodProxy.create(clazz2, clazz, "(Ljava/lang/Object;)Z", "equals", "CGLIB$equals$2");
        CGLIB$toString$3$Method = methodArray[2];
        CGLIB$toString$3$Proxy = MethodProxy.create(clazz2, clazz, "()Ljava/lang/String;", "toString", "CGLIB$toString$3");
        CGLIB$hashCode$4$Method = methodArray[3];
        CGLIB$hashCode$4$Proxy = MethodProxy.create(clazz2, clazz, "()I", "hashCode", "CGLIB$hashCode$4");
        CGLIB$clone$5$Method = methodArray[4];
        CGLIB$clone$5$Proxy = MethodProxy.create(clazz2, clazz, "()Ljava/lang/Object;", "clone", "CGLIB$clone$5");
    }

    private static final void CGLIB$BIND_CALLBACKS(Object object) {
        block2: {
            Object object2;
            block3: {
                TrainStation$$EnhancerByCGLIB$$f3f5c491 trainStation$$EnhancerByCGLIB$$f3f5c491 = (TrainStation$$EnhancerByCGLIB$$f3f5c491)object;
                if (trainStation$$EnhancerByCGLIB$$f3f5c491.CGLIB$BOUND) break block2;
                trainStation$$EnhancerByCGLIB$$f3f5c491.CGLIB$BOUND = true;
                object2 = CGLIB$THREAD_CALLBACKS.get();
                if (object2 != null) break block3;
                object2 = CGLIB$STATIC_CALLBACKS;
                if (CGLIB$STATIC_CALLBACKS == null) break block2;
            }
            trainStation$$EnhancerByCGLIB$$f3f5c491.CGLIB$CALLBACK_0 = (MethodInterceptor)((Callback[])object2)[0];
        }
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
        //Cglib
        CglibProxyFactory factory1 = new CglibProxyFactory();
        TrainStation proxyObject1 = factory1.getProxyObject();
        proxyObject1.sell();
    }
}
```

### 三种代理的对比

* jdk代理和CGLIB代理

  使用CGLib实现动态代理，CGLib底层采用ASM字节码生成框架，使用字节码技术生成代理类，在JDK1.6之前比使用Java反射效率要高。唯一需要注意的是，CGLib不能对声明为final的类或者方法进行代理，因为CGLib原理是动态生成被代理类的子类。

  在JDK1.6、JDK1.7、JDK1.8逐步对JDK动态代理优化之后，在调用次数较少的情况下，JDK代理效率高于CGLib代理效率，只有当进行大量调用的时候，JDK1.6和JDK1.7比CGLib代理效率低一点，但是到JDK1.8的时候，JDK代理效率高于CGLib代理。所以如果有接口使用JDK动态代理，如果没有接口使用CGLIB代理。

* 动态代理和静态代理

  动态代理与静态代理相比较，最大的好处是接口中声明的所有方法都被转移到调用处理器一个集中的方法中处理（InvocationHandler.invoke）。这样，在接口方法数量比较多的时候，我们可以进行灵活处理，而不需要像静态代理那样每一个方法进行中转。

  如果接口增加一个方法，静态代理模式除了所有实现类需要实现这个方法外，所有代理类也需要实现此方法。增加了代码维护的复杂度。而动态代理不会出现该问题

### 优缺点

#### 优点

- 代理模式在客户端与目标对象之间起到一个中介作用和保护目标对象的作用；
- 代理对象可以扩展目标对象的功能；
- 代理模式能将客户端与目标对象分离，在一定程度上降低了系统的耦合度；

#### 缺点

增加了系统的复杂度；

### 使用场景

* 远程（Remote）代理

  本地服务通过网络请求远程服务。为了实现本地到远程的通信，我们需要实现网络通信，处理其中可能的异常。为良好的代码设计和可维护性，我们将网络通信部分隐藏起来，只暴露给本地服务一个接口，通过该接口即可访问远程服务提供的功能，而不必过多关心通信部分的细节。

* 防火墙（Firewall）代理

  当你将浏览器配置成使用代理功能时，防火墙就将你的浏览器的请求转给互联网；当互联网返回响应时，代理服务器再把它转给你的浏览器。

* 保护（Protect or Access）代理

  控制对一个对象的访问，如果需要，可以给不同的用户提供不同级别的使用权限。