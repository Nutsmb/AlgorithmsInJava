package FightClub;

class Warrior extends Hero {


    public Warrior(String _name) {
        super(_name);
        this.maxHealth = 500;
        this.minHealth = 400;
        this.maxDamage = 100;
        this.minDamage = 80;
        this.health = generateRandomStates(minHealth,maxHealth);
        this.name = _name;
        this.damage = minDamage;
    }

    @Override
    void hit(Hero hero) {
        if (hero != this) {
            if(health <= 0) {
                System.out.println(this.name + " погиб и бить не может!");
            } else {
                damage = generateRandomStates(minDamage,maxDamage);
                hero.causeDamage(damage);
                System.out.println(this.name + " нанес урон " + hero.name);
            }
        }
    }

    @Override
    void healing(Hero hero) {
        System.out.println("Войны не умеют лечить!");
    }
}
