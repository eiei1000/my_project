package jp.ac.uryukyu.ie.e245739;

public class Warrior extends Hero {
    public Warrior(String name, int maximumHP, int attack) {
        super(name, maximumHP, attack);
    }

    public void attackWithWeaponSkill(LivingThing opponent) {
        if (opponent.isDead()) {
            return;
        }
        int damage = (int)(getAttack() * 1.5); // 150%のダメージ
        opponent.wounded(damage);
        System.out.printf("%sの攻撃！ウェポンスキルを発動！%sに%dのダメージを与えた！！\n", getName(), opponent.getName(), damage);
    }
}