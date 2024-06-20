package space.jiguanchen.product.prototype;

import java.util.Hashtable;

/**
 * @Description: 缓存类，用于存储和管理敌人对象
 * @Author: jiguanchen
 * @Date: 2024/6/20 16:35
 */
public class EnemyCache {
    private static final Hashtable<String, Enemy> enemyMap = new Hashtable<>();

    // 获取敌人的克隆对象
    public static Enemy getEnemy(String enemyId) {
        Enemy cachedEnemy = enemyMap.get(enemyId);
        return (Enemy) cachedEnemy.clone(); // 克隆敌人对象
    }

    // 预加载敌人对象到缓存中
    public static void loadCache() {
        Zombie zombie = new Zombie();
        zombie.setId("1");
        enemyMap.put(zombie.getId(), zombie);

        Alien alien = new Alien();
        alien.setId("2");
        enemyMap.put(alien.getId(), alien);
    }
}