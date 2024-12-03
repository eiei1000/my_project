package jp.ac.uryukyu.ie.e245739;

/**
 * 敵クラス。
 *  String name; //敵の名前
 *  int hitPoint; //敵のHP
 *  int attack; //敵の攻撃力
 *  boolean dead; //敵の生死状態。true=死亡。
 * Created by tnal on 2016/11/13.
 */
public class Enemy {
    public String name;
    public int hitPoint;
    public int attack;
    public boolean dead;

    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * @param name モンスター名
     * @param maximumHP モンスターのHP
     * @param attack モンスターの攻撃力
     */
    public Enemy (String name, int maximumHP, int attack) {
        this.name = name;
        hitPoint = maximumHP;
        this.attack = attack;
        dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
    }

    /**
     * Heroへ攻撃するメソッド。
     * attackに応じて乱数でダメージを算出し、hero.wounded()によりダメージ処理を実行。
     * @param hero 攻撃対象
     */
    public void attack(Hero hero) {
        // 自分が死亡していたら攻撃できない
        if (this.dead) {
            System.out.println(this.name + "は死亡しているため、攻撃できません！");
            return;  // 攻撃を中止
        }
    
        // 相手のヒーローが死亡していたら攻撃できない
        if (hero.dead) {
            System.out.println(hero.name + "は既に死亡しているため、攻撃できません！");
            return;  // 攻撃を中止
        }
    
        // ダメージの計算
        int damage = (int)(Math.random() * this.attack);
        System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", this.name, hero.name, damage);
        hero.wounded(damage);  // ヒーローにダメージを与える
    }
    /**
     * 自身へ攻撃されたときのダメージ処理をするメソッド。
     * 指定されたダメージを hitPoint から引き、死亡判定を行う。
     * @param damage 受けたダメージ
     */
    public void wounded(int damage){
        hitPoint -= damage;
        if( hitPoint < 0 ) {
            dead = true;
            System.out.printf("モンスター%sは倒れた。\n", name);
        }
    }

}