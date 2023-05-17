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