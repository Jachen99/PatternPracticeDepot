package space.jiguanchen.product.factory.myFactory;

/**
 * @Description: 创业创办公司模型的工厂类
 * @Author: jiguanchen
 * @Date: 2024/6/19 15:44
 */
public class StartupCompanyFactory implements TenAheadModelFactory {
    @Override
    public TenAheadModel createTenAheadModel() {
        return new StartupCompanyModel();
    }
}