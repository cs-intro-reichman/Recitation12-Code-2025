// TOPIC: extends, @Override
// Zombie has 50% chance to attack, deals poison damage

public class Zombie extends Monster {
    protected int poisonDamage;

    public Zombie(String name, int hitPoints, int strength, int poisonDamage) {
        super(name, hitPoints, strength);
        if (poisonDamage <= 0) {
            throw new IllegalArgumentException();
        }
        this.poisonDamage = poisonDamage;
    }

    public int getPoisonDamage() {
        return this.poisonDamage;
    }

    // Zombie doesn't override takeDamage - uses Monster's implementation

    // Implement abstract method - 50% chance to attack
    @Override
    public int attack(Monster other) {
        if (this.didAttack()) {
            int res = other.takeDamage(this.strength + this.poisonDamage);
            return res;
        }
        return 0;
    }

    public boolean didAttack() {
        return Math.random() < 0.5;
    }
}
