package space.jiguanchen.product.prototype;

/**
 * @Description: 原型模式
 * @Author: jiguanchen
 * @Date: 2024/6/20 16:36
 */
public class PrototypePatternDemo {
    public static void main(String[] args) {
        // 加载缓存
        EnemyCache.loadCache();

        // 从缓存中获取克隆的敌人对象
        Enemy clonedEnemy1 = EnemyCache.getEnemy("1");
        System.out.println("Enemy : " + clonedEnemy1.getType());
        clonedEnemy1.attack();

        Enemy clonedEnemy2 = EnemyCache.getEnemy("2");
        System.out.println("Enemy : " + clonedEnemy2.getType());
        clonedEnemy2.attack();
    }
}
