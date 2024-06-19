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
        // 创建多个线程同时获取单例实例
        Thread thread1 = new Thread(() -> {
            EagerSingletonConfigManager configManager1 = EagerSingletonConfigManager.getInstance();
            configManager1.setConfigValue("Thread 1 Config Value");
            log.info("Thread 1: 当前配置值: {}", configManager1.getConfigValue());
        });

        Thread thread2 = new Thread(() -> {
            EagerSingletonConfigManager configManager2 = EagerSingletonConfigManager.getInstance();
            log.info("Thread 2: 当前配置值: {}", configManager2.getConfigValue());
        });

        Thread thread3 = new Thread(() -> {
            EagerSingletonConfigManager configManager3 = EagerSingletonConfigManager.getInstance();
            log.info("Thread 3: 当前配置值: {}", configManager3.getConfigValue());
        });

        // 启动线程
        thread1.start();
        try {
            thread1.join(); // 确保thread1先执行完
        } catch (InterruptedException e) {
            log.error("线程中断");
            e.printStackTrace();
        }
        thread2.start();
        thread3.start();

        // 验证是否是同一个实例
        EagerSingletonConfigManager configManagerMain = EagerSingletonConfigManager.getInstance();
        log.info("Main Thread: 当前配置值: {}", configManagerMain.getConfigValue());

        // 断言检查
        assert configManagerMain.getConfigValue().equals("Thread 1 Config Value");
    }

}