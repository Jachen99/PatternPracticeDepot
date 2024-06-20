package space.jiguanchen.product.prototype;

import lombok.Getter;
import lombok.Setter;

/**
 * @Description: 抽象类 Enemy，实现 Cloneable 接口，以支持克隆
 * @Author: jiguanchen
 * @Date: 2024/6/20 16:33
 */
@Getter
@Setter
public abstract class Enemy implements Cloneable {
    private String id; // 敌人的唯一标识符
    protected String type; // 敌人的类型

    // 抽象方法，定义敌人的攻击行为
    abstract void attack();

    // 实现克隆方法，返回敌人的副本
    @Override
    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone(); // 调用 Object 类的 clone() 方法
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}
