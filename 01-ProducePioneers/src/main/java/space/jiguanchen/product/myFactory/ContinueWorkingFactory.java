package space.jiguanchen.product.myFactory;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description: 继续工作
 * @Author: jiguanchen
 * @Date: 2024/5/30 21:17
 */
@Slf4j
public class ContinueWorkingFactory implements TenAheadModelFactory{
    @Override
    public TenAheadModel createTenAheadModel() {
        return new TenAheadModel() {
            @Override
            public void tenAheadToLive() {
                log.info("\n 进入模型1:{{}}   十年后，我选择了在北京继续打工。。。", this.getClass().getName());
            }
        };
    }
}
