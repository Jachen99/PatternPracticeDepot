package space.jiguanchen.product.builder;

import lombok.Setter;

/**
 * @Description: 房屋建造
 *    在房屋建造过程中，建造步骤非常复杂，需要分步骤完成。使用建造者模式可以按照特定顺序构建房屋。
 * @Author: jiguanchen
 * @Date: 2024/6/20 14:05
 */
@Setter
class House {
    private String foundation; // 地基
    private String structure; // 结构
    private String roof; // 屋顶

    @Override
    public String toString() {
        return "House{" +
                "foundation='" + foundation + '\'' +
                ", structure='" + structure + '\'' +
                ", roof='" + roof + '\'' +
                '}';
    }
}

// 抽象建造者接口
interface HouseBuilder {
    void buildFoundation(); // 构建地基
    void buildStructure(); // 构建结构
    void buildRoof(); // 构建屋顶
    House getHouse(); // 获取房屋
}

// 具体建造者 - 现代房屋
class ModernHouseBuilder implements HouseBuilder {
    private final House house = new House(); // 实例化房屋对象

    @Override
    public void buildFoundation() {
        house.setFoundation("设置地基为混凝土");
    }

    @Override
    public void buildStructure() {
        house.setStructure("设置结构为钢结构");
    }

    @Override
    public void buildRoof() {
        house.setRoof("设置屋顶为玻璃");
    }

    @Override
    public House getHouse() {
        return house; // 返回构建好的现代房屋
    }
}

// 具体建造者 - 传统房屋
class TraditionalHouseBuilder implements HouseBuilder {
    private final House house = new House(); // 实例化房屋对象

    @Override
    public void buildFoundation() {
        house.setFoundation("设置地基为砖");
    }

    @Override
    public void buildStructure() {
        house.setStructure("设置结构为木结构");
    }

    @Override
    public void buildRoof() {
        house.setRoof("设置屋顶为瓦片");
    }

    @Override
    public House getHouse() {
        return house; // 返回构建好的传统房屋
    }
}

// 指挥者
class HouseDirector {
    public void construct(HouseBuilder builder) {
        builder.buildFoundation(); // 构建地基
        builder.buildStructure(); // 构建结构
        builder.buildRoof(); // 构建屋顶
    }
}

// 客户端代码
public class HouseClient {
    public static void main(String[] args) {
        HouseDirector director = new HouseDirector();

        HouseBuilder modernHouseBuilder = new ModernHouseBuilder();
        director.construct(modernHouseBuilder); // 构建现代房屋
        House modernHouse = modernHouseBuilder.getHouse();
        System.out.println("现代房屋：" + modernHouse);

        HouseBuilder traditionalHouseBuilder = new TraditionalHouseBuilder();
        director.construct(traditionalHouseBuilder); // 构建传统房屋
        House traditionalHouse = traditionalHouseBuilder.getHouse();
        System.out.println("传统房屋：" + traditionalHouse);
    }
}
