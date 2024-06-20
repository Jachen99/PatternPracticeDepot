# 创建型模式
创建型模式主要关注对象的创建过程，目的是将对象的创建和使用分离，提升代码的灵活性和可扩展性。（提供了一种在创建对象的同时隐藏创建逻辑的方式，而不是使用 new 运算符直接实例化对象）

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
Computer： 产品类，表示要构建的复杂对象。
ComputerBuilder： 抽象建造者接口，定义了构建产品各个部件的方法。
HighEndComputerBuilder 和 LowEndComputerBuilder： 具体建造者实现类，负责实现具体产品各个部件的构建和装配。
Director： 指挥者类，负责调用具体建造者来构建产品。
Client： 客户端代码，演示如何使用建造者模式来构建不同配置的电脑对象。
建造者模式通过将复杂对象的构建过程分解成多个简单步骤，使得客户端代码可以根据需求选择不同的建造者来构建不同配置的产品。这样既保证了构建过程的灵活性和复用性，又隐藏了产品内部构建细节，符合面向对象设计的开闭原则。