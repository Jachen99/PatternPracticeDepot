package space.jiguanchen.product.singleton;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description: 日志管理器，使用饿汉单例模式
 * @Author: jiguanchen
 * @Date: 2024/6/19 16:34
 */
@Slf4j
public class EagerSingletonLogManager {

    // 实例化静态成员：在类加载时就创建实例
    private static final EagerSingletonLogManager instance = new EagerSingletonLogManager();

    // 私有构造函数，防止外部实例化
    private EagerSingletonLogManager() {
        log.info("日志管理器已初始化。");
    }

    // 提供公共的静态方法获取实例
    public static EagerSingletonLogManager getInstance() {
        return instance;
    }

    // 记录日志
    public void logMessage(String message) {
        log.info("日志: {}", message);
    }

    // 测试方法
    public static void main(String[] args) {
        // 创建多个线程同时获取日志管理器实例
        Thread thread1 = new Thread(() -> {
            EagerSingletonLogManager logManager = EagerSingletonLogManager.getInstance();
            logManager.logMessage("Thread 1 日志。");
        });

        Thread thread2 = new Thread(() -> {
            EagerSingletonLogManager logManager = EagerSingletonLogManager.getInstance();
            logManager.logMessage("Thread 2 日志。");
        });

        thread1.start();
        thread2.start();

        // 等待两个线程执行完毕
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            log.error("线程被中断。", e);
        }

        // 验证是否是同一个实例
        EagerSingletonLogManager logManager1 = EagerSingletonLogManager.getInstance();
        EagerSingletonLogManager logManager2 = EagerSingletonLogManager.getInstance();
        log.info("logManager1 == logManager2: {}", logManager1 == logManager2);
    }
}
