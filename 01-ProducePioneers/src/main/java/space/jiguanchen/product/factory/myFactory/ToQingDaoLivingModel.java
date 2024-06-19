package space.jiguanchen.product.factory.myFactory;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description: 去青岛生活的模型实现
 * @Author: jiguanchen
 * @Date: 2024/6/19 15:54
 */
@Slf4j
public class ToQingDaoLivingModel implements TenAheadModel {
    @Override
    public void tenAheadToLive() {
        log.info("\n 进入模型3:{{}}   十年后，我选择了去青岛生活。。。", this.getClass().getName());
    }
}