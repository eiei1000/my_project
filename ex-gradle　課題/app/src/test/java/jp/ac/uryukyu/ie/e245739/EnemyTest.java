package jp.ac.uryukyu.ie.e245739;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;  // assertFalseをインポート
import org.junit.jupiter.api.Test;

class EnemyTest {
    /**
     * 倒れたはずの敵は攻撃できないことを検証。
     * 検証手順
     *  (1) ヒーローと敵を準備。ヒーローの攻撃力は敵を一撃で倒せるほど強い状態とする。
     *  (2) ヒーローが殴り、敵も殴る。敵は一撃で倒されていることを期待。
     *  (3) 敵が死んだ状態ならば攻撃できないはず。
     * 　　つまり攻撃実行してもヒーローのHPは減っていないことを期待。これを検証する。
     */
    @Test
    void attackTest() {
        int defaultHeroHp = 100;
        Hero demoHero = new Hero("デモ勇者", defaultHeroHp, 100);
        Enemy slime = new Enemy("スライムもどき", 10, 100);
        
        // スライムが生きていることを確認
        assertFalse(slime.dead, "スライムはまだ死んでいないはずです");

        // ヒーローがスライムに攻撃を行う
        demoHero.attack(slime);

        // スライムが死亡したか確認
        assertTrue(slime.dead, "スライムはヒーローの攻撃で死亡したはずです");

        // スライムが再度ヒーローに攻撃を試みる
        slime.attack(demoHero);

        // ヒーローのHPが減っていないことを確認
        assertEquals(defaultHeroHp, demoHero.hitPoint, "ヒーローのHPが減っていないはずです");
    }
}