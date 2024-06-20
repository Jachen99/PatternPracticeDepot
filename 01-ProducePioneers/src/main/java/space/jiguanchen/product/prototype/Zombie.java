package space.jiguanchen.product.prototype;

/**
 * @Description: 具体敌人类型：Zombie
 * @Author: jiguanchen
 * @Date: 2024/6/20 16:34
 */
public class Zombie extends Enemy {
    public Zombie() {
        type = "Zombie";
    }

    @Override
    public void attack() {
        System.out.println("Zombie attacks with a bite!");
    }
}