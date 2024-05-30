package space.jiguanchen.product.factory.abstractFactory;

import space.jiguanchen.product.factory.model.PowerPredictionModel;

/**
 * @Description: 抽象能源预测模型工厂接口
 * @Author: jiguanchen
 * @Date: 2024/5/30 16:19
 */
public interface PowerPredictionModelFactory {

    /**
     * 创建能源预测模型
     *
     * @return 对应能源类型的能源预测模型
     */
    PowerPredictionModel createPowerPredictionModel();

}