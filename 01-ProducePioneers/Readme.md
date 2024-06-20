# 创建型模式
创建型模式主要关注对象的创建过程，目的是将对象的创建和使用分离，提升代码的灵活性和可扩展性。（提供了一种在创建对象的同时隐藏创建逻辑的方式，而不是使用 new 运算符直接实例化对象）

## 工厂模式（Factory Pattern）
简单工厂模式是工厂模式的一种，它包括一个工厂类和一组产品类。工厂类负责根据客户端的请求创建并返回适当类型的产品对象。客户端只需要通过工厂类的静态方法来获取所需的产品对象，而无需直接实例化产品对象。简单工厂模式适用于对象的创建逻辑相对简单，不需要太多的灵活性和扩展性的场景。

下面是一个简单工厂模式的示例代码：

```java
// 产品接口
interface Product {
    void use();
}

// 具体产品类 A
class ConcreteProductA implements Product {
    @Override
    public void use() {
        System.out.println("使用具体产品 A");
    }
}

// 具体产品类 B
class ConcreteProductB implements Product {
    @Override
    public void use() {
        System.out.println("使用具体产品 B");
    }
}

// 工厂类
class SimpleFactory {
    public static Product createProduct(String type) {
        if ("A".equals(type)) {
            return new ConcreteProductA();
        } else if ("B".equals(type)) {
            return new ConcreteProductB();
        }
        throw new IllegalArgumentException("Unsupported product type: " + type);
    }
}

// 客户端代码
public class Client {
    public static void main(String[] args) {
        // 创建产品 A
        Product productA = SimpleFactory.createProduct("A");
        productA.use();

        // 创建产品 B
        Product productB = SimpleFactory.createProduct("B");
        productB.use();
    }
}

```
## 抽象工厂模式（Abstract Factory Pattern）

抽象工厂模式是一种创建型设计模式，它提供一个接口，用于创建一系列相关或相互依赖的对象，而无需指定它们具体的类。抽象工厂模式通常用于生产“产品族”，即一系列相关的产品对象，这些产品对象可能在某种上下文或某个场景下一起使用。

抽象工厂模式的主要参与者包括：

- **抽象工厂（Abstract Factory）**：声明创建一系列相关产品对象的方法。
- **具体工厂（Concrete Factory）**：实现创建产品对象的方法。
- **抽象产品（Abstract Product）**：为一类产品对象声明接口。
- **具体产品（Concrete Product）**：定义具体工厂生产的具体产品对象，实现抽象产品接口。
- **客户端（Client）**：使用抽象工厂来创建一组相关的产品。

抽象产品
```java
// 抽象产品 A
interface Button {
    void paint();
}

// 抽象产品 B
interface Checkbox {
    void paint();
}
```
具体产品
```java
// 具体产品 A1
class WindowsButton implements Button {
    @Override
    public void paint() {
        System.out.println("You have created WindowsButton.");
    }
}

// 具体产品 A2
class MacButton implements Button {
    @Override
    public void paint() {
        System.out.println("You have created MacButton.");
    }
}

// 具体产品 B1
class WindowsCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("You have created WindowsCheckbox.");
    }
}

// 具体产品 B2
class MacCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("You have created MacCheckbox.");
    }
}
```
抽象工厂

```java
// 抽象工厂
interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

```

具体工厂

```java
// 具体工厂 1
class WindowsFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}

// 具体工厂 2
class MacFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}

```

客户端代码

```java
public class Client {
    private Button button;
    private Checkbox checkbox;

    public Client(GUIFactory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }

    public void paint() {
        button.paint();
        checkbox.paint();
    }

    public static void main(String[] args) {
        // 使用Windows风格的组件
        GUIFactory windowsFactory = new WindowsFactory();
        Client windowsClient = new Client(windowsFactory);
        windowsClient.paint();

        // 使用Mac风格的组件
        GUIFactory macFactory = new MacFactory();
        Client macClient = new Client(macFactory);
        macClient.paint();
    }
}

```
抽象工厂模式通过提供一个接口来创建一系列相关或相互依赖的对象，从而使客户端代码与这些对象的创建过程解耦。这样，当需要更换一组相关产品时，只需要更换具体工厂类，而无需修改客户端代码。抽象工厂模式的优点是使得代码更加灵活和可扩展，能够方便地添加新的产品族。


## 单例模式（Singleton Pattern）

单例模式（Singleton Pattern）是一种创建型设计模式，它确保一个类只有一个实例，并提供一个全局访问点来访问该实例。单例模式通常用于需要全局唯一对象的场景，例如配置管理对象、线程池、日志对象等。

单例模式的实现主要包含以下几个关键点：

**私有化构造函数**：防止外部通过构造函数创建实例。
**持有自己类的唯一实例**：通过静态成员变量持有单例实例。
**提供一个公开的静态方法**：用于获取唯一实例。

1. 饿汉式单例（Eager Initialization）
   这种实现方式在类加载时就创建单例实例，线程安全，但可能造成资源浪费。


```java

public class EagerSingleton {
   private static final EagerSingleton INSTANCE = new EagerSingleton();

   private EagerSingleton() {
      // 私有构造函数
   }

   public static EagerSingleton getInstance() {
      return INSTANCE;
   }
}

```
2. 懒汉式单例（Lazy Initialization）
   这种实现方式在第一次调用 getInstance 方法时创建单例实例，不是线程安全的。

```java
public class LazySingleton {
   private static LazySingleton instance;

   private LazySingleton() {
      // 私有构造函数
   }

   public static LazySingleton getInstance() {
      if (instance == null) {
         instance = new LazySingleton();
      }
      return instance;
   }
}
```

3. 线程安全的懒汉式单例（Thread-Safe Lazy Initialization）
   通过同步 getInstance 方法来确保线程安全，但同步开销较大。

```java

public class ThreadSafeLazySingleton {
   private static ThreadSafeLazySingleton instance;

   private ThreadSafeLazySingleton() {
      // 私有构造函数
   }

   public static synchronized ThreadSafeLazySingleton getInstance() {
      if (instance == null) {
         instance = new ThreadSafeLazySingleton();
      }
      return instance;
   }
}

```

4. 双重检查锁定（Double-Checked Locking）
   这种方式在减少同步开销的同时保证了线程安全。

```java
public class DoubleCheckedLockingSingleton {
   private static volatile DoubleCheckedLockingSingleton instance;

   private DoubleCheckedLockingSingleton() {
      // 私有构造函数
   }

   public static DoubleCheckedLockingSingleton getInstance() {
      if (instance == null) {
         synchronized (DoubleCheckedLockingSingleton.class) {
            if (instance == null) {
               instance = new DoubleCheckedLockingSingleton();
            }
         }
      }
      return instance;
   }
}
```
5. 静态内部类（Static Inner Class）
   利用类加载机制实现延迟加载，线程安全且实现简单。


```java

public class StaticInnerClassSingleton {
   private StaticInnerClassSingleton() {
// 私有构造函数
   }

   private static class SingletonHelper {
      private static final StaticInnerClassSingleton INSTANCE = new StaticInnerClassSingleton();
   }

   public static StaticInnerClassSingleton getInstance() {
      return SingletonHelper.INSTANCE;
   }
}

```
6. 枚举（Enum）
   枚举类型天生是单例的，且线程安全，防止反序列化创建新对象。
```java

public enum EnumSingleton {
INSTANCE;

    public void doSomething() {
        // 业务方法
    }
}

```
### 单例模式的优缺点

**优点：**
- 确保系统中只有一个实例，节省资源。
- 提供全局访问点，方便管理。

**缺点：**
- 不适合对资源消耗较大的对象使用，因为即使不使用，实例也会一直存在。
- 在多线程环境中实现难度较大，需要注意线程安全问题。

### 适用场景

单例模式适用于需要确保唯一实例且提供全局访问点的场景，如配置类、数据库连接池、日志类等。它通过限制实例化次数和提供全局访问点，确保一个类只有一个实例，并可以方便地在不同地方使用这个实例。



## 建造者模式（Builder Pattern）
建造者模式是一种创建型设计模式，用于通过多个简单的对象构建一个复杂的对象。它允许按步骤创建对象，将复杂对象的构建过程和表示分离，从而使同样的构建过程可以创建不同的表示。

### 主要参与者
- **Builder（建造者）：** 定义构建产品各个部件的抽象接口。
- **ConcreteBuilder（具体建造者）：** 实现Builder接口，构建和装配各个部件。
- **Director（指挥者）：** 负责调用具体建造者，按照一定的顺序来构建产品。
- **Product（产品）：** 最终构建出的复杂对象。

### 优点
- **分步构建：** 将构建逻辑分解到单独的步骤中，使得构建过程更加灵活，可以按需组合和构建对象。
- **隐藏复杂性：** 客户端不需要知道产品内部构建细节，只需通过指挥者按步骤来构建即可。
- **重用性：** 可以复用相同的构建过程来创建不同的表示。

### 示例代码
假设我们要构建一个电脑对象，包含CPU、内存和硬盘等组件，以下是建造者模式的示例代码：

```java
// 产品类 - 电脑
class Computer {
    private String cpu;
    private String memory;
    private String hardDisk;

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public void setHardDisk(String hardDisk) {
        this.hardDisk = hardDisk;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", memory='" + memory + '\'' +
                ", hardDisk='" + hardDisk + '\'' +
                '}';
    }
}

// 抽象建造者接口
interface ComputerBuilder {
    void buildCPU();
    void buildMemory();
    void buildHardDisk();
    Computer getComputer();
}

// 具体建造者 - 高配版电脑
class HighEndComputerBuilder implements ComputerBuilder {
    private Computer computer = new Computer();

    @Override
    public void buildCPU() {
        computer.setCpu("Intel i7");
    }

    @Override
    public void buildMemory() {
        computer.setMemory("16GB DDR4");
    }

    @Override
    public void buildHardDisk() {
        computer.setHardDisk("512GB SSD");
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}

// 具体建造者 - 低配版电脑
class LowEndComputerBuilder implements ComputerBuilder {
    private Computer computer = new Computer();

    @Override
    public void buildCPU() {
        computer.setCpu("Intel i3");
    }

    @Override
    public void buildMemory() {
        computer.setMemory("8GB DDR4");
    }

    @Override
    public void buildHardDisk() {
        computer.setHardDisk("256GB SSD");
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}

// 指挥者
class Director {
    public void construct(ComputerBuilder builder) {
        builder.buildCPU();
        builder.buildMemory();
        builder.buildHardDisk();
    }
}

// 客户端代码
public class Client {
    public static void main(String[] args) {
        Director director = new Director();

        ComputerBuilder highEndBuilder = new HighEndComputerBuilder();
        director.construct(highEndBuilder);
        Computer highEndComputer = highEndBuilder.getComputer();
        System.out.println("高配版电脑配置：" + highEndComputer);

        ComputerBuilder lowEndBuilder = new LowEndComputerBuilder();
        director.construct(lowEndBuilder);
        Computer lowEndComputer = lowEndBuilder.getComputer();
        System.out.println("低配版电脑配置：" + lowEndComputer);
    }
}
```

**Computer**：产品类，表示要构建的复杂对象。

**ComputerBuilder**：抽象建造者接口，定义了构建产品各个部件的方法。

**HighEndComputerBuilder 和 LowEndComputerBuilder**：具体建造者实现类，负责实现具体产品各个部件的构建和装配。

**Director**：指挥者类，负责调用具体建造者来构建产品。

**Client**：客户端代码，演示如何使用建造者模式来构建不同配置的电脑对象。

建造者模式通过将复杂对象的构建过程分解成多个简单步骤，使得客户端代码可以根据需求选择不同的建造者来构建不同配置的产品。这样既保证了构建过程的灵活性和复用性，又隐藏了产品内部构建细节，符合面向对象设计的开闭原则。


## 原型模式（Prototype Pattern）

原型模式是一种创建型设计模式，允许通过复制现有的对象来创建新对象，而不是通过实例化（new）来创建。该模式提供了一种机制，
通过从原型对象中创建对象的副本来创建新的对象，从而简化对象的创建过程，并且可以避免构建复杂对象时的性能消耗。

主要参与者
Prototype（原型）：声明一个克隆自身的接口。
ConcretePrototype（具体原型）：实现克隆的操作，以便返回一个与自身相同的对象。
Client（客户端）：通过调用原型对象的克隆方法来创建新的对象。
优点
简化对象创建：通过克隆现有对象创建新对象，简化了对象的创建过程。
性能提升：避免了重复复杂对象的初始化过程，从而提高性能。
灵活性：可以在运行时动态地创建对象的副本，而不必依赖于具体类。

```java

/**
 * 示例代码  假设我们要创建一个复杂的图形对象，这个图形对象包含多个子图形。使用原型模式可以简化这个过程。
 */

// 原型接口
interface Shape extends Cloneable {
   Shape clone();

   void draw();
}

// 具体原型类 - 圆形
class Circle implements Shape {
   private int radius;

   public Circle(int radius) {
      this.radius = radius;
   }

   @Override
   public Shape clone() {
      return new Circle(this.radius);
   }

   @Override
   public void draw() {
      System.out.println("Drawing a Circle with radius " + radius);
   }
}

// 具体原型类 - 矩形
class Rectangle implements Shape {
   private int width;
   private int height;

   public Rectangle(int width, int height) {
      this.width = width;
      this.height = height;
   }

   @Override
   public Shape clone() {
      return new Rectangle(this.width, this.height);
   }

   @Override
   public void draw() {
      System.out.println("Drawing a Rectangle with width " + width + " and height " + height);
   }
}

// 原型管理器
class ShapePrototypeManager {
   private Map<String, Shape> shapeMap = new HashMap<>();

   public void registerShape(String key, Shape shape) {
      shapeMap.put(key, shape);
   }

   public Shape getShape(String key) {
      Shape shape = shapeMap.get(key);
      return shape.clone();
   }
}

// 客户端代码
public class Client {
   public static void main(String[] args) {
      ShapePrototypeManager prototypeManager = new ShapePrototypeManager();

      // 注册原型
      prototypeManager.registerShape("Circle", new Circle(5));
      prototypeManager.registerShape("Rectangle", new Rectangle(10, 20));

      // 克隆原型
      Shape clonedCircle = prototypeManager.getShape("Circle");
      Shape clonedRectangle = prototypeManager.getShape("Rectangle");

      // 使用克隆对象
      clonedCircle.draw();
      clonedRectangle.draw();
   }
}
```
### 主要参与者
1. **Prototype（原型）：** 声明一个克隆自身的接口。
2. **ConcretePrototype（具体原型）：** 实现克隆自身的操作。
3. **Client（客户端）：** 通过调用原型对象的克隆方法来创建新的对象。

### 优点
1. **简化对象创建：** 通过复制现有对象来创建新对象，而不是通过复杂的构造过程。
2. **性能提升：** 当对象创建成本较高时，通过克隆来创建新对象可以显著提升性能。
3. **灵活性和可扩展性：** 可以方便地扩展新的原型对象，而无需修改客户端代码。

### 缺点
1. **深拷贝和浅拷贝的实现复杂度：** 特别是当对象包含其他对象时，实现深拷贝可能较为复杂。
2. **对象间的引用问题：** 需要处理好对象之间的引用关系，以避免克隆后的对象出现不一致的状态。

### 生活中的实例
1. **细胞分裂：** 细胞通过自身的复制产生新的细胞，类似于原型模式中的克隆。
2. **软件开发中的拷贝功能：** 在文本编辑器中，通过复制粘贴功能创建新的文本副本。
3. **游戏开发中的对象克隆：** 在游戏中，通过克隆现有的敌人对象创建新的敌人，以节省资源和时间。

### 原型模式的应用
1. **文档管理系统：** 通过克隆模板文档创建新的文档。
2. **图形编辑器：** 在图形编辑器中，通过克隆现有图形对象创建新的图形对象。
3. **游戏开发：** 在游戏开发中，通过克隆现有对象（如敌人、道具等）创建新的对象。