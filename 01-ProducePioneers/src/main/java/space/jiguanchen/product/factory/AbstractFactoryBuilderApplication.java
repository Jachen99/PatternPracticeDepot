package space.jiguanchen.product.factory;

import space.jiguanchen.product.factory.abstractFactory.HydroPowerPredictionModelFactory;
import space.jiguanchen.product.factory.abstractFactory.PowerPredictionModelFactory;
import space.jiguanchen.product.factory.abstractFactory.SolarPowerPredictionModelFactory;
import space.jiguanchen.product.factory.abstractFactory.WindPowerPredictionModelFactory;
import space.jiguanchen.product.factory.model.PowerPredictionModel;

/**
 * @Description: 抽象工厂模式启动类
 * @Author: jiguanchen
 * @Date: 2024/5/30 16:18
 */
public class AbstractFactoryBuilderApplication {
    public static void main(String[] args) {
        System.out.println("================start===============");

        // 创建风能预测模型工厂
        PowerPredictionModelFactory windFactory = new WindPowerPredictionModelFactory();
        PowerPredictionModel windModel = windFactory.createPowerPredictionModel();
        double windPower = windModel.predictPower();
        System.out.println("风能预测电力产量：" + windPower + "千瓦时");

        // 创建太阳能预测模型工厂
        PowerPredictionModelFactory solarFactory = new SolarPowerPredictionModelFactory();
        PowerPredictionModel solarModel = solarFactory.createPowerPredictionModel();
        double solarPower = solarModel.predictPower();
        System.out.println("太阳能预测电力产量：" + solarPower + "千瓦时");

        // 创建水力能预测模型工厂
        PowerPredictionModelFactory hydroFactory = new HydroPowerPredictionModelFactory();
        PowerPredictionModel hydroModel = hydroFactory.createPowerPredictionModel();
        double hydroPower = hydroModel.predictPower();
        System.out.println("水力能预测电力产量：" + hydroPower + "千瓦时");
        System.out.println("================end===============");
    }
}