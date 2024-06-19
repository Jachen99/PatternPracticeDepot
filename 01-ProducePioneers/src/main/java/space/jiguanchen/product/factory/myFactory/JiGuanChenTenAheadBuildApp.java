package space.jiguanchen.product.factory.myFactory;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description: JiGuanChenTenAheadBuildApp 主类，展示未来十年模型应用
 * @Author: jiguanchen
 * @Date: 2024/5/30 21:09
 */
@Slf4j
public class JiGuanChenTenAheadBuildApp {

    public static void main(String[] args) {
        // 使用 ContinueWorkingFactory 创建模型并展示
        runFactory(new ContinueWorkingFactory());

        // 使用 StartupCompanyFactory 创建模型并展示
        runFactory(new StartupCompanyFactory());

        // 使用 ToQingDaoLivingFactory 创建模型并展示
        runFactory(new ToQingDaoLivingFactory());
    }

    /**
     * @Description: 工厂方法运行模型
     * @param factory TenAheadModelFactory 工厂实例
     */
    private static void runFactory(TenAheadModelFactory factory) {
        TenAheadModel model = factory.createTenAheadModel();
        model.tenAheadToLive();
    }
}
