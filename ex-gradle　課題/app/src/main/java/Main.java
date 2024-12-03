import jp.ac.uryukyu.ie.e245739.Enemy;
import jp.ac.uryukyu.ie.e245739.Warrior;

public class Main {
    public static void main(String[] args){
        Warrior warrior = new Warrior("勇者", 10, 5);
        Enemy enemy = new Enemy("スライム", 6, 3);

        System.out.printf("%s vs. %s\n", warrior.getName(), enemy.getName());

        int turn = 0;
        while (!warrior.isDead() && !enemy.isDead()) {
            turn++;
            System.out.printf("%dターン目開始！\n", turn);
            
            warrior.attackWithWeaponSkill(enemy);
            if (enemy.isDead()) {  // スライムが死んでいたらループを終了
                break;
            }

            enemy.attack(warrior);
        }

        System.out.println("戦闘終了");
    }
}