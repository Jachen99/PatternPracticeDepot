package space.jiguanchen.product.builder;

import lombok.Setter;

/**
 * @Description: 餐厅点餐系统
 * 在餐厅点餐时，顾客可以按需选择不同的餐品组合来形成一份餐点。餐厅使用建造者模式可以灵活地组合餐品。
 * @Author: jiguanchen
 * @Date: 2024/6/20 14:01
 */
@Setter
class Meal {
    private String mainCourse; // 主菜
    private String side; // 配菜
    private String drink; // 饮料

    @Override
    public String toString() {
        return "Meal{" +
                "mainCourse='" + mainCourse + '\'' +
                ", side='" + side + '\'' +
                ", drink='" + drink + '\'' +
                '}';
    }
}

// 抽象建造者接口
interface MealBuilder {
    void buildMainCourse(); // 构建主菜
    void buildSide(); // 构建配菜
    void buildDrink(); // 构建饮料
    Meal getMeal(); // 获取餐点
}

// 具体建造者 - 素食餐点
class VegMealBuilder implements MealBuilder {
    private final Meal meal = new Meal(); // 实例化餐点对象

    @Override
    public void buildMainCourse() {
        meal.setMainCourse("设置主菜为蔬菜汉堡");
    }

    @Override
    public void buildSide() {
        meal.setSide("设置配菜为沙拉");
    }

    @Override
    public void buildDrink() {
        meal.setDrink("设置饮料为橙汁");
    }

    @Override
    public Meal getMeal() {
        return meal; // 返回构建好的素食餐点
    }
}

// 具体建造者 - 非素食餐点
class NonVegMealBuilder implements MealBuilder {
    private final Meal meal = new Meal(); // 实例化餐点对象

    @Override
    public void buildMainCourse() {
        meal.setMainCourse("设置主菜为鸡肉汉堡");
    }

    @Override
    public void buildSide() {
        meal.setSide("设置配菜为薯条");
    }

    @Override
    public void buildDrink() {
        meal.setDrink("设置饮料为可乐");
    }

    @Override
    public Meal getMeal() {
        return meal; // 返回构建好的非素食餐点
    }
}

// 指挥者
class MealDirector {
    public void construct(MealBuilder builder) {
        builder.buildMainCourse(); // 构建主菜
        builder.buildSide(); // 构建配菜
        builder.buildDrink(); // 构建饮料
    }
}

// 客户端代码
public class MealClient {
    public static void main(String[] args) {
        MealDirector director = new MealDirector();

        MealBuilder vegMealBuilder = new VegMealBuilder();
        director.construct(vegMealBuilder); // 构建素食餐点
        Meal vegMeal = vegMealBuilder.getMeal();
        System.out.println("素食餐点：" + vegMeal);

        MealBuilder nonVegMealBuilder = new NonVegMealBuilder();
        director.construct(nonVegMealBuilder); // 构建非素食餐点
        Meal nonVegMeal = nonVegMealBuilder.getMeal();
        System.out.println("非素食餐点：" + nonVegMeal);
    }
}
