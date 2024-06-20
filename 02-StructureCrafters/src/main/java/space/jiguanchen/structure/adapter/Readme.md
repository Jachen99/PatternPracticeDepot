# 结构型模式 
结构型模式关注类和对象的组合，解决如何组装对象和类以获得新的功能或改进现有功能。

## 适配器模式（Adapter Pattern）

适配器模式（Adapter Pattern）是一种结构型设计模式，用于将一个类的接口转换成客户希望的另一个接口。适配器模式使得原本由于接口不兼容而不能一起工作的类可以协同工作。适配器模式分为类适配器和对象适配器两种。

### 类适配器模式

类适配器模式通过多继承（在 Java 中是通过实现接口和继承类）来实现适配器。

### 对象适配器模式

对象适配器模式通过组合的方式来实现适配器。

### 适配器模式的主要角色

- **目标接口（Target）**：客户所期待的接口。目标可以是具体的或抽象的类，也可以是接口。
- **需要适配的类（Adaptee）**：需要适配的类或对象。
- **适配器（Adapter）**：通过继承或引用需要适配的对象，将需要适配的接口转换成目标接口。

### 类适配器示例
假设我们有一个现有的 VGA 接口，但现在需要使用 HDMI 接口的功能。

```java

// 目标接口（HDMI）
interface HDMI {
    void connectWithHDMI();
}

// 需要适配的类（VGA）
class VGA {
    public void connectWithVGA() {
        System.out.println("Connecting with VGA...");
    }
}

// 对象适配器
class HDMIAdapter implements HDMI {
    private VGA vga;

    public HDMIAdapter(VGA vga) {
        this.vga = vga;
    }

    @Override
    public void connectWithHDMI() {
        vga.connectWithVGA();
    }
}

// 客户端代码
public class ObjectAdapterDemo {
    public static void main(String[] args) {
        VGA vga = new VGA();
        HDMI hdmi = new HDMIAdapter(vga);
        hdmi.connectWithHDMI();
    }
}
```

### 适配器模式的优缺点
#### 优点
- **增加类的透明性和复用性**：通过使用适配器模式，可以让不相关的类一起工作，提高类的复用性。
- **提高了类的透明性**：客户类通过目标接口与适配器交互，不需要了解具体的适配过程，符合“开闭原则”。
- **灵活性好**：可以很方便地替换适配器类或者扩展适配器类来实现新的适配功能。
#### 缺点
- **过多的适配器类**：如果系统中需要适配的接口非常多，可能会导致产生大量的适配器类，增加系统的复杂性。
- **不支持所有情况**：对于一些特殊的接口适配，适配器模式可能并不是最好的解决方案。
### 适用场景
- **现有类的接口不符合需求**：现有的类接口与客户类期望的接口不匹配，需要通过适配器模式进行转换。
- **需要复用一些现存的类**：这些类可能没有兼容的接口，通过适配器模式可以将它们转换为所需的接口。
- **通过适配器模式，可以有效地将不兼容的接口适配到一起，从而提高系统的灵活性和可扩展性。**