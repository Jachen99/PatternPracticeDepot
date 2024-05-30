```markdown
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
## 单例模式（Singleton Pattern）
## 建造者模式（Builder Pattern）
## 原型模式（Prototype Pattern）
```