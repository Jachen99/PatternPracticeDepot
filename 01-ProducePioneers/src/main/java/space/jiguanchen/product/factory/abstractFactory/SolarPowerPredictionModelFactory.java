package space.jiguanchen.product.factory.abstractFactory;


import space.jiguanchen.product.factory.model.PowerPredictionModel;
import space.jiguanchen.product.factory.model.SolarPowerPredictionModel;

/**
 * @Description: 太阳能预测模型工厂
 * @Author: jiguanchen
 * @Date: 2024/5/30 16:29
 */
public class SolarPowerPredictionModelFactory implements PowerPredictionModelFactory {

    @Override
    public PowerPredictionModel createPowerPredictionModel() {
        return new SolarPowerPredictionModel();
    }
}