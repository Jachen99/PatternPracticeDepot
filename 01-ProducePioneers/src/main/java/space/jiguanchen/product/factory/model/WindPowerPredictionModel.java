package space.jiguanchen.product.factory.model;

/**
 * @Description: 风能预测模型
 * @Author: jiguanchen
 * @Date: 2024/5/30 16:21
 */
public class WindPowerPredictionModel implements PowerPredictionModel {
    @Override
    public double predictPower() {
        // 实现风能电力预测的算法
        return 1000.0; // 假设返回的电力产量是1000千瓦时
    }
}