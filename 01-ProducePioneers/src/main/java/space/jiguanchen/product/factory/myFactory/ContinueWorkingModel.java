package space.jiguanchen.product.factory.myFactory;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description: 继续工作的模型实现
 * @Author: jiguanchen
 * @Date: 2024/6/19 15:44
 */
@Slf4j
public class ContinueWorkingModel implements TenAheadModel {
    @Override
    public void tenAheadToLive() {
        log.info("\n 进入模型1:{{}}   十年后，我选择了在北京继续打工。。。", this.getClass().getName());
    }
}