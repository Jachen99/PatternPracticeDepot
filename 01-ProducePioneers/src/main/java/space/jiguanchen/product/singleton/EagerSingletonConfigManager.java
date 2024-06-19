package space.jiguanchen.product.singleton;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description: 饿汉式单例模式
 * @Author: jiguanchen
 * @Date: 2024/6/19 16:34
 */
@Setter
@Slf4j
public class EagerSingletonConfigManager {

    // 1、实例化静态成员：在类加载时就创建实例
    @Getter
    private static final EagerSingletonConfigManager instance = new EagerSingletonConfigManager();

    @Getter
    private String configValue;

    // 私有构造函数，防止外部实例化
    private EagerSingletonConfigManager() {
        // 模拟加载配置
        configValue = "默认配置值";
        log.info("配置管理器已初始化。");
    }

    /**
     * 饿汉单例模式之所以是线程安全的，是因为实例在类加载时就被创建，类加载的过程是线程安全的。
     * Java类加载机制保证了类加载时的线程安全性：JVM在加载类时，会自动获得一个锁，确保只有一个线程能够初始化类。
     * 因此，在类加载过程中创建的单例实例天然是线程安全的。
     *
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        // 获取实例并使用
        EagerSingletonConfigManager configManager1 = EagerSingletonConfigManager.getInstance();
        log.info("当前配置值: {}", configManager1.getConfigValue());

        // 修改配置信息
        configManager1.setConfigValue("新配置值");

        // 再次获取实例并验证配置信息是否一致
        EagerSingletonConfigManager configManager2 = EagerSingletonConfigManager.getInstance();
        log.info("当前配置值: {}", configManager2.getConfigValue());
    }
}