// TOPIC: extends, super keyword, @Override
// Vampire has 25% dodge chance and heals when attacking

public class Vampire extends Monster {

    // ============ Constructor ============

    public Vampire(String name, int hitPoints, int strength) {
        super(name, hitPoints, strength);
    }

    // ============ Override from Monster ============

    // 25% chance to dodge
    @Override
    public int takeDamage(int damage) {
        if (this.didDodge()) {
            return 0;
        }
        return super.takeDamage(damage);
    }

    // Implement abstract method - heals 1/3 of damage dealt
    @Override
    public int attack(Monster other) {
        int hp = other.takeDamage(this.strength);
        this.heal(hp);
        return hp;
    }

    // ============ Vampire-specific Methods ============

    public void heal(int hitPoints) {
        this.hitPoints += hitPoints / 3;
    }

    public boolean didDodge() {
        return Math.random() < 0.25;
    }
}
