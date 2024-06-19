package space.jiguanchen.product.myFactory;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description: 创业创办公司
 * @Author: jiguanchen
 * @Date: 2024/6/19 15:44
 */
@Slf4j
public class StartupCompanyFactory implements TenAheadModelFactory{
    @Override
    public TenAheadModel createTenAheadModel() {
        return new TenAheadModel() {
            @Override
            public void tenAheadToLive() {
                log.info("\n 进入模型2:{{}}    十年后，我选择了创业创办公司。。。", this.getClass().getName());
            }
        };
    }
}
