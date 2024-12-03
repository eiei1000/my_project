package jp.ac.uryukyu.ie.e245739;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class WarriorTest {

    @Test
    public void testAttackWithWeaponSkill() {
        int slimeHp = 50;  // スライムの初期HP
        Warrior warrior = new Warrior("ウォリアーリオ", 100, 20);
        Enemy enemy = new Enemy("スライム", slimeHp, 10);

        // 期待されるダメージ計算（攻撃力の1.5倍）
        int expectedDamage = (int) (warrior.getAttack() * 1.5);

        // 1回目の攻撃を実行
        warrior.attackWithWeaponSkill(enemy);
        
        // 期待されるHP差分を確認
        assertEquals(expectedDamage, slimeHp - enemy.getHitPoint());
    }
}