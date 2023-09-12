package space.jiguanchen.FactoryBuilder;

/**
 * @Description: 太阳能预测模型
 * @Auther: jiguanchen
 * @Date: 2023/9/12 17:29
 */
public class SolarPowerPredictionModel implements PowerPredictionModel {
    @Override
    public double predictPower() {
        // 实现太阳能电力预测的算法
        return 800.0; // 假设返回的电力产量是800千瓦时
    }
}