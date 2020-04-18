package FightClub;

class Doctor extends Hero {

    public Doctor(String _name) {
        super(_name);
        this.maxHealth = 150;
        this.minHealth = 100;
        this.maxDamage = 10;
        this.minDamage = 1;
        this.maxaddHeal = 10;
        this.minaddHeal = 50;
        this.health = generateRandomStates(minHealth,maxHealth);
        this.name = name;
        this.damage = generateRandomStates(minDamage,maxDamage);
        this.addHeal = minaddHeal;
    }

    @Override
    void hit(Hero hero) {
        if (hero != this) {
            if(health <= 0) {
                System.out.println("Герой погиб и бить не может!");
            } else {
                hero.causeDamage(damage);
                System.out.println(this.name + " нанес урон " + hero.name);
            }
        }
    }

    @Override
    void healing(Hero hero) {
        addHeal = generateRandomStates(minaddHeal,maxaddHeal);
        hero.addHealth(addHeal);
    }
}
