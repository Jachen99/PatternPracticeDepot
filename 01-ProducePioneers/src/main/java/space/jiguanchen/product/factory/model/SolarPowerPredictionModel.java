package space.jiguanchen.product.factory.model;

/**
 * @Description: 太阳能预测模型
 * @Author: jiguanchen
 * @Date: 2024/5/30 16:30
 */
public class SolarPowerPredictionModel implements PowerPredictionModel {
    @Override
    public double predictPower() {
        // 实现太阳能电力预测的算法
        return 800.0; // 假设返回的电力产量是800千瓦时
    }
}