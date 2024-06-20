# 创建型模式 
创建型模式主要关注对象的创建过程，目的是将对象的创建和使用分离，提升代码的灵活性和可扩展性。（提供了一种在创建对象的同时隐藏创建逻辑的方式，而不是使用 new 运算符直接实例化对象）

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
import java.util.HashMap;
import java.util.Map;

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
生活中的实例
细胞分裂：细胞通过自身的复制产生新的细胞，类似于原型模式中的克隆。
软件开发中的拷贝功能：在文本编辑器中，通过复制粘贴功能创建新的文本副本。
游戏开发中的对象克隆：在游戏中，通过克隆现有的敌人对象创建新的敌人，以节省资源和时间。

原型模式的应用
文档管理系统：通过克隆模板文档创建新的文档。
图形编辑器：在图形编辑器中，通过克隆现有图形对象创建新的图形对象。
游戏开发：在游戏开发中，通过克隆现有对象（如敌人、道具等）创建新的对象。

原型模式的优缺点
优点
简化对象创建： 通过复制现有对象来创建新对象，而不是通过复杂的构造过程。
性能提升： 当对象创建成本较高时，通过克隆来创建新对象可以显著提升性能。
灵活性和可扩展性： 可以方便地扩展新的原型对象，而无需修改客户端代码。
缺点
深拷贝和浅拷贝的实现复杂度： 特别是当对象包含其他对象时，实现深拷贝可能较为复杂。
对象间的引用问题： 需要处理好对象之间的引用关系，以避免克隆后的对象出现不一致的状态。

通过原型模式，能够有效地简化对象的创建过程，提高系统的灵活性和性能，是一种非常实用的创建型设计模式。