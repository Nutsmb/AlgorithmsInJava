package FightClub;

abstract class Hero {

    protected int health;
    protected String name;
    protected int damage;
    protected int addHeal;

    protected int maxHealth;
    protected int minHealth;
    protected int maxDamage;
    protected int minDamage;
    protected int maxaddHeal;
    protected int minaddHeal;

    public Hero(String name) {
        this.name = name;
    }

    abstract void hit(Hero hero);

    abstract void healing(Hero hero);

    void causeDamage(int damage) {
        if(health <= 0) {
            System.out.println(this.name + " уже мертвый!");
        } else {
            health = (this.health < damage) ? 0 : (health -= damage);
        }
    }

    public int getHealth() {
        return health;
    }

    void addHealth(int health) {
        int temp = this.health;
        if(health > 0) {
            this.health = (temp + health > maxHealth) ? maxHealth : (this.health + health);
        }
    }

    void info() {

        System.out.println(name + " " + (health <= 0 ? " мертвый" : health) + " " + damage);//
    }

    int generateRandomStates(int _minRange, int _maxRange){
        return (int) (Math.random()*(_maxRange - _minRange + 1) + _minRange);
    }
}
