package jp.ac.uryukyu.ie.e245739;

public class LivingThing {
    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;

    public LivingThing(String name, int hitPoint, int attack){
        this.name = name;
        this.hitPoint = hitPoint;
        this.attack = attack;
        this.dead = false;
    }

    public void attack(LivingThing opponent){
        if (!isDead()){
            int damage = (int)(Math.random() * attack);
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, opponent.getName(), damage);
            opponent.wounded(damage);
        }
    }

    public void wounded(int damage){
        hitPoint -= damage;
        if (hitPoint <= 0) {
            dead = true;
            System.out.printf("%sは倒れた。\n", name);
        }
    }

    public void setHitPoint(int hitPoint) {
        this.hitPoint = hitPoint;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public String getName() { return name; }
    public int getHitPoint() { return hitPoint; }
    public int getAttack() { return attack; }
    public boolean isDead() { return dead; }

    @Override
    public String toString(){
        return name + ", HP=" + hitPoint + ", Attack=" + attack + ", Dead=" + dead;
    }
}