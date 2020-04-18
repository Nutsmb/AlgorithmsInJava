package FightClub;

import java.util.Random;

class Assasin extends Hero {

    int cricitalHit;
    Random random = new Random();

    public Assasin(String _name) {
        super(_name);
        this.maxHealth = 300;
        this.minHealth = 150;
        this.maxDamage = 90;
        this.minDamage = 40;
        this.health = generateRandomStates(minHealth,maxHealth);
        this.name = name;
        this.damage = minDamage;
        this.cricitalHit = random.nextInt(20);
    }

    @Override
    void hit(Hero hero) {
        if (hero != this) {
            if(health <= 0) {
                System.out.println(this.name + " погиб и бить не может!");
            } else {
                damage = generateRandomStates(minDamage,maxDamage);
                hero.causeDamage(damage + cricitalHit);
                System.out.println(this.name + " нанес урон " + hero.name);
            }
        }
    }

    @Override
    void healing(Hero hero) {
        System.out.println("Убийцы не умеют лечить!");
    }
}