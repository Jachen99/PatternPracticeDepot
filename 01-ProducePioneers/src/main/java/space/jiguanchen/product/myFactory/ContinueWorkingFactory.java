package space.jiguanchen.product.myFactory;

/**
 * @Description: 继续工作模型的工厂类
 * @Author: jiguanchen
 * @Date: 2024/5/30 21:17
 */
public class ContinueWorkingFactory implements TenAheadModelFactory {
    @Override
    public TenAheadModel createTenAheadModel() {
        return new ContinueWorkingModel();
    }
}