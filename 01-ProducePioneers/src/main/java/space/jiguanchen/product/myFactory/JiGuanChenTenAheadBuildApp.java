package space.jiguanchen.product.myFactory;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description: 10-AheadModelApp  未来十年模型
 * @Author: jiguanchen
 * @Date: 2024/5/30 21:09
 */
@Slf4j
public class JiGuanChenTenAheadBuildApp {

    public static void main(String[] args) {
        ContinueWorkingFactory continueWorkingFactory = new ContinueWorkingFactory();
        TenAheadModel tenAheadModel = continueWorkingFactory.createTenAheadModel();
        tenAheadModel.tenAheadToLive();

        StartupCompanyFactory startupCompanyFactory = new StartupCompanyFactory();
        tenAheadModel = startupCompanyFactory.createTenAheadModel();
        tenAheadModel.tenAheadToLive();

        ToQingDaoLivingFactory toQingDaoLivingFactory = new ToQingDaoLivingFactory();
        tenAheadModel = toQingDaoLivingFactory.createTenAheadModel();
        tenAheadModel.tenAheadToLive();
    }
}
