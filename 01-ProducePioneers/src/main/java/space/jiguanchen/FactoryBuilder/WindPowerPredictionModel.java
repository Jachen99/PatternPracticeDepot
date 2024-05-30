package space.jiguanchen.FactoryBuilder;

/**
 * @Description: 风能预测模型
 * @Auther: jiguanchen
 * @Date: 2023/9/12 17:23
 */
public class WindPowerPredictionModel implements PowerPredictionModel {
    @Override
    public double predictPower() {
        // 实现风能电力预测的算法
        return 1000.0; // 假设返回的电力产量是1000千瓦时
    }
}