package space.jiguanchen.product.factory.abstractFactory;

import space.jiguanchen.product.factory.model.HydroPowerPredictionModel;
import space.jiguanchen.product.factory.model.PowerPredictionModel;

/**
 * @Description: 水力能预测模型工厂
 * @Author: jiguanchen
 * @Date: 2024/5/30 16:31
 */
public class HydroPowerPredictionModelFactory implements PowerPredictionModelFactory {

    @Override
    public PowerPredictionModel createPowerPredictionModel() {
        return new HydroPowerPredictionModel();
    }
}