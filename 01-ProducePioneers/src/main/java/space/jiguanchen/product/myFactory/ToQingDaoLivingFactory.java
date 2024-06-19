package space.jiguanchen.product.myFactory;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description: 去青岛工作
 * @Author: jiguanchen
 * @Date: 2024/6/19 15:54
 */
@Slf4j
public class ToQingDaoLivingFactory implements TenAheadModelFactory{


    @Override
    public TenAheadModel createTenAheadModel() {

        return new TenAheadModel() {
            @Override
            public void tenAheadToLive() {
                log.info("\n 进入模型3:{{}}   十年后，我选择了去青岛生活。。。", this.getClass().getName());
            }
        };
    }
}
