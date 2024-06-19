package space.jiguanchen.product.singleton;

import lombok.extern.slf4j.Slf4j;

/**
 * 懒汉式单例模式
 */
@Slf4j
public class LazySingletonManager {

    // 私有静态成员变量，volatile关键字确保多线程环境下的可见性和禁止指令重排序
    private static volatile LazySingletonManager instance;

    // 私有构造方法，防止外部实例化
    private LazySingletonManager() {
        log.info("日志管理器已初始化。");
    }

    // 提供公共的静态方法获取实例
    public static LazySingletonManager getInstance() {
        // 双重检查锁定，保证了懒加载和线程安全
        if (instance == null) {
            synchronized (LazySingletonManager.class) {
                if (instance == null) {
                    instance = new LazySingletonManager();
                }
            }
        }
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
            LazySingletonManager manager = LazySingletonManager.getInstance();
            manager.logMessage("Thread 1 日志。");
        });

        Thread thread2 = new Thread(() -> {
            LazySingletonManager manager = LazySingletonManager.getInstance();
            manager.logMessage("Thread 2 日志。");
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
        LazySingletonManager manager1 = LazySingletonManager.getInstance();
        LazySingletonManager manager2 = LazySingletonManager.getInstance();
        assert manager1 == manager2;

        manager1.logMessage("主线程日志。");
        manager2.logMessage("主线程日志。");
    }
}
