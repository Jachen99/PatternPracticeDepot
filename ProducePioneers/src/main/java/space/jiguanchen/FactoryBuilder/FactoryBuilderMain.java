package space.jiguanchen.FactoryBuilder;

/**
 * @Description: 工厂模式启动类
 * @Auther: jiguanchen
 * @Date: 2023/9/12 15:49
 */
public class FactoryBuilderMain {
    public static void main(String[] args) {
        System.out.println("================start===============");

        PowerPredictionModelFactory factory = new PowerPredictionModelFactory();

        PowerPredictionModel windModel = factory.createPowerPredictionModel("wind");
        double windPower = windModel.predictPower();
        System.out.println("风能预测电力产量：" + windPower + "千瓦时");

        PowerPredictionModel solarModel = factory.createPowerPredictionModel("solar");
        double solarPower = solarModel.predictPower();
        System.out.println("太阳能预测电力产量：" + solarPower + "千瓦时");

        PowerPredictionModel hydroModel = factory.createPowerPredictionModel("hydro");
        double hydroPower = hydroModel.predictPower();
        System.out.println("水力能预测电力产量：" + hydroPower + "千瓦时");
    }
}