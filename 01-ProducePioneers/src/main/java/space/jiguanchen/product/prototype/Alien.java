package space.jiguanchen.product.prototype;

/**
 * @Description: 具体敌人类型：Alien
 * @Author: jiguanchen
 * @Date: 2024/6/20 16:34
 */
public class Alien extends Enemy {
    public Alien() {
        type = "Alien";
    }

    @Override
    public void attack() {
        System.out.println("Alien attacks with a laser!");
    }
}
