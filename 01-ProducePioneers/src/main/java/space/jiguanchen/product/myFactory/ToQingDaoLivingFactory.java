package space.jiguanchen.product.myFactory;

/**
 * @Description: 去青岛生活模型的工厂类
 * @Author: jiguanchen
 * @Date: 2024/6/19 15:54
 */
public class ToQingDaoLivingFactory implements TenAheadModelFactory {
    @Override
    public TenAheadModel createTenAheadModel() {
        return new ToQingDaoLivingModel();
    }
}