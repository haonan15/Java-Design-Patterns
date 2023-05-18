## 桥接模式

### 概念

将抽象与实现分离，使它们可以独立变化。它是用组合关系代替继承关系来实现，从而降低了抽象和实现这两个可变维度的耦合度。

### 结构

桥接（Bridge）模式包含以下主要角色：

* 抽象化（Abstraction）角色 ：定义抽象类，并包含一个对实现化对象的引用。
* 扩展抽象化（Refined  Abstraction）角色 ：是抽象化角色的子类，实现父类中的业务方法，并通过组合关系调用实现化角色中的业务方法。
* 实现化（Implementor）角色 ：定义实现化角色的接口，供扩展抽象化角色调用。
* 具体实现化（Concrete Implementor）角色 ：给出实现化角色接口的具体实现。

### 实现

开发一个跨平台视频播放器，可以在不同操作系统平台（如Windows、Mac、Linux等）上播放多种格式的视频文件，常见的视频格式包括RMVB、AVI、WMV等。该播放器包含了两个维度，适合使用桥接模式。

![image-20230518195358121](https://cloud-image-host.oss-cn-beijing.aliyuncs.com/img/202305181953207.png)

**抽象化角色**

```java
/**
 * 操作系统类，抽象角色
 * @author Ether
 */
public abstract class OperatingSystem {

    protected VideoFile videoFile;

    public OperatingSystem(VideoFile videoFile){
        this.videoFile = videoFile;
    }

    public abstract void play(String fileName);

}
```

**扩展抽象化角色**

```java
/**
 * 扩展抽象化角色，Windows操作系统
 * @author Ether
 */
public class Windows extends OperatingSystem{

    public Windows(VideoFile videoFile) {
        super(videoFile);
    }

    @Override
    public void play(String fileName) {
        videoFile.decode(fileName);
    }
}
```

```java
/**
 * Mac操作系统，扩展抽象化角色
 * @author Ether
 */
public class Mac extends OperatingSystem{

    public Mac(VideoFile videoFile) {
        super(videoFile);
    }

    @Override
    public void play(String fileName) {
        videoFile.decode(fileName);
    }
}
```

**实现化角色**

```java
/**
 * 视频文件（实现化角色）
 * @author Ether
 */
public interface VideoFile {

    //解码功能
    void decode(String fileName);

}
```

**具体实现化角色**

```java
/**
 * 具体实现化角色，rmvb视频文件
 * @author Ether
 */
public class RmvbFile implements VideoFile{
    @Override
    public void decode(String fileName) {
        System.out.println("rmvb视频文件:" + fileName);
    }
}
```

```java
/**
 * AVI视频角色，实现化角色
 * @author Ether
 */
public class AviFile implements VideoFile{
    @Override
    public void decode(String fileName) {
        System.out.println("avi视频文件:" + fileName);
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
        //创建Mac操作系统
        OperatingSystem system = new Mac(new AviFile());
        system.play("黑豹2");
    }
}
```

### 特点

* 特点：如果现在还有一种视频文件类型wmv，我们只需要再定义一个类实现VideoFile接口即可，其他类不需要发生变化。

  如：如果现在还有一种视频文件类型wmv，我们只需要再定义一个类实现VideoFile接口即可，其他类不需要发生变化。

* 实现细节对客户透明

### 使用场景

* 当一个类存在两个独立变化的维度，且这两个维度都需要进行扩展时。
* 当一个系统不希望使用继承或因为多层次继承导致系统类的个数急剧增加时。
* 当一个系统需要在构件的抽象化角色和具体化角色之间增加更多的灵活性时。避免在两个层次之间建立静态的继承联系，通过桥接模式可以使它们在抽象层建立一个关联关系。