package space.jiguanchen.FactoryBuilder;


/**
 * @Description: 能源预测模型工厂
 * @Auther: jiguanchen
 * @Date: 2023/9/12 16:38
 */
public class PowerPredictionModelFactory {

    public PowerPredictionModel createPowerPredictionModel(String energySource) {
        if ("wind".equalsIgnoreCase(energySource)) {
            return new WindPowerPredictionModel();
        } else if ("solar".equalsIgnoreCase(energySource)) {
            return new SolarPowerPredictionModel();
        } else if ("hydro".equalsIgnoreCase(energySource)) {
            return new HydroPowerPredictionModel();
        } else {
            throw new IllegalArgumentException("不支持的能源来源");
        }
    }

}
