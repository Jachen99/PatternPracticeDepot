# 创建型模式 
创建型模式主要关注对象的创建过程，目的是将对象的创建和使用分离，提升代码的灵活性和可扩展性。（提供了一种在创建对象的同时隐藏创建逻辑的方式，而不是使用 new 运算符直接实例化对象）

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
