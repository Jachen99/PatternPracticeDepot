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

抽象工厂（Abstract Factory）：声明创建一系列相关产品对象的方法。
具体工厂（Concrete Factory）：实现创建产品对象的方法。
抽象产品（Abstract Product）：为一类产品对象声明接口。
具体产品（Concrete Product）：定义具体工厂生产的具体产品对象，实现抽象产品接口。
客户端（Client）：使用抽象工厂来创建一组相关的产品。
示例代码
假设我们要创建一个界面组件库，有两套不同风格的组件：Windows风格和Mac风格。我们将使用抽象工厂模式来实现。

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
## 建造者模式（Builder Pattern）
## 原型模式（Prototype Pattern）