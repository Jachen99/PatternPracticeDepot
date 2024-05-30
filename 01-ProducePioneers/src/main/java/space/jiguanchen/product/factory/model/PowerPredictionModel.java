package space.jiguanchen.product.factory.model;

/**
 * @Description: 抽象能源预测模型接口
 * @Auther: jiguanchen
 * @Date: 2023/9/12 17:22
 */
public interface PowerPredictionModel {

    /**
     * 预测能源产量
     *
     * @return 预测的能源产量（千瓦时）
     */
    double predictPower();

}
