package space.jiguanchen.product.builder;

import lombok.Setter;

/**
 * @Description: 旅游套餐定制
 *      在定制旅游套餐时，用户可以选择不同的交通工具、住宿和景点组合来形成一个完整的旅游套餐。使用建造者模式可以灵活地组合这些选择。
 * @Author: jiguanchen
 * @Date: 2024/6/20 14:11
 */
@Setter
class TravelPackage {
    private String transportation; // 交通工具
    private String accommodation; // 住宿
    private String sightseeing; // 观光

    @Override
    public String toString() {
        return "TravelPackage{" +
                "transportation='" + transportation + '\'' +
                ", accommodation='" + accommodation + '\'' +
                ", sightseeing='" + sightseeing + '\'' +
                '}';
    }
}

// 抽象建造者接口
interface TravelPackageBuilder {
    void buildTransportation(); // 构建交通工具
    void buildAccommodation(); // 构建住宿
    void buildSightseeing(); // 构建观光
    TravelPackage getTravelPackage(); // 获取旅游套餐
}

// 具体建造者 - 豪华旅游套餐
class LuxuryTravelPackageBuilder implements TravelPackageBuilder {
    private final TravelPackage travelPackage = new TravelPackage(); // 实例化旅游套餐对象

    @Override
    public void buildTransportation() {
        travelPackage.setTransportation("设置交通工具为头等舱航班");
    }

    @Override
    public void buildAccommodation() {
        travelPackage.setAccommodation("设置住宿为五星级酒店");
    }

    @Override
    public void buildSightseeing() {
        travelPackage.setSightseeing("设置观光为私人导游");
    }

    @Override
    public TravelPackage getTravelPackage() {
        return travelPackage; // 返回构建好的豪华旅游套餐
    }
}

// 具体建造者 - 经济旅游套餐
class BudgetTravelPackageBuilder implements TravelPackageBuilder {
    private final TravelPackage travelPackage = new TravelPackage(); // 实例化旅游套餐对象

    @Override
    public void buildTransportation() {
        travelPackage.setTransportation("设置交通工具为经济舱航班");
    }

    @Override
    public void buildAccommodation() {
        travelPackage.setAccommodation("设置住宿为三星级酒店");
    }

    @Override
    public void buildSightseeing() {
        travelPackage.setSightseeing("设置观光为团体旅游");
    }

    @Override
    public TravelPackage getTravelPackage() {
        return travelPackage; // 返回构建好的经济旅游套餐
    }
}

// 具体建造者 - 自助旅游套餐
class CustomTravelPackageBuilder implements TravelPackageBuilder {
    private final TravelPackage travelPackage = new TravelPackage(); // 实例化旅游套餐对象

    @Override
    public void buildTransportation() {
        travelPackage.setTransportation("设置交通工具为自驾车");
    }

    @Override
    public void buildAccommodation() {
        travelPackage.setAccommodation("设置住宿为度假出租房");
    }

    @Override
    public void buildSightseeing() {
        travelPackage.setSightseeing("设置观光为灵活观光");
    }

    @Override
    public TravelPackage getTravelPackage() {
        return travelPackage; // 返回构建好的自助旅游套餐
    }
}

// 指挥者
class TravelDirector {
    public void construct(TravelPackageBuilder builder) {
        builder.buildTransportation(); // 构建交通工具
        builder.buildAccommodation(); // 构建住宿
        builder.buildSightseeing(); // 构建观光
    }
}

// 客户端代码
public class TravelClient {
    public static void main(String[] args) {
        TravelDirector director = new TravelDirector();

        // 构建豪华旅游套餐
        TravelPackageBuilder luxuryBuilder = new LuxuryTravelPackageBuilder();
        director.construct(luxuryBuilder);
        TravelPackage luxuryPackage = luxuryBuilder.getTravelPackage();
        System.out.println("豪华旅游套餐：" + luxuryPackage);

        // 构建经济旅游套餐
        TravelPackageBuilder budgetBuilder = new BudgetTravelPackageBuilder();
        director.construct(budgetBuilder);
        TravelPackage budgetPackage = budgetBuilder.getTravelPackage();
        System.out.println("经济旅游套餐：" + budgetPackage);

        // 构建自助旅游套餐
        TravelPackageBuilder customBuilder = new CustomTravelPackageBuilder();
        director.construct(customBuilder);
        TravelPackage customPackage = customBuilder.getTravelPackage();
        System.out.println("自助旅游套餐：" + customPackage);
    }
}
