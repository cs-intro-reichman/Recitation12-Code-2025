// TOPIC: extends with additional fields
// Knight has defense (reduces damage) and 10% critical hit chance

public class Knight extends Monster {
    private int defense;
    private TitleEnum title;

    public Knight(String name, int hitPoints, int strength, int defense, TitleEnum title) {
        super(name, hitPoints, strength);
        this.defense = defense;
        this.title = title;
    }

    public int getDefense() {
        return this.defense;
    }

    public TitleEnum getTitle() {
        return this.title;
    }

    // Override takeDamage - reduce damage by defense
    @Override
    public int takeDamage(int damage) {
        int damageTaken = (damage - this.defense);
        if (damageTaken < 0) {
            damageTaken = 0;
        }
        damageTaken = super.takeDamage(damageTaken);
        return damageTaken;
    }

    // Implement abstract method - 10% critical hit (double damage)
    @Override
    public int attack(Monster other) {
        int res;
        if (this.isCriticalHit()) {
            res = other.takeDamage(this.strength * 2);
        } else {
            res = other.takeDamage(this.strength);
        }
        return res;
    }

    public boolean isCriticalHit() {
        return Math.random() < 0.1;
    }
}
