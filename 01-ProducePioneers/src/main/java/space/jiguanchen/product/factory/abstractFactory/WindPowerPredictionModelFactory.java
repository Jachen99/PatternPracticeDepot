package space.jiguanchen.product.factory.abstractFactory;

import space.jiguanchen.product.factory.model.PowerPredictionModel;
import space.jiguanchen.product.factory.model.WindPowerPredictionModel;

/**
 * @Description: 风能预测模型工厂
 * @Author: jiguanchen
 * @Date: 2024/5/30 16:20
 */
public class WindPowerPredictionModelFactory implements PowerPredictionModelFactory {

    @Override
    public PowerPredictionModel createPowerPredictionModel() {
        return new WindPowerPredictionModel();
    }
}