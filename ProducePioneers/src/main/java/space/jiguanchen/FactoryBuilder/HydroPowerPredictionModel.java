package space.jiguanchen.FactoryBuilder;

/**
 * @Description: 水力能预测模型
 * @Auther: jiguanchen
 * @Date: 2023/9/12 17:29
 */
public class HydroPowerPredictionModel implements PowerPredictionModel {
    @Override
    public double predictPower() {
        // 实现水力能电力预测的算法
        return 1200.0; // 假设返回的电力产量是1200千瓦时
    }
}