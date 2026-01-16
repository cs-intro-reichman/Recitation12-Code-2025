// TOPIC: extends, super keyword, @Override
// Dragon takes half damage and attacks with fire

public class Dragon extends Monster {
    protected int fireDamage;

    // ============ Constructor ============

    public Dragon(String name, int hitPoints, int strength, int fireDamage) {
        super(name, hitPoints, strength);
        if (fireDamage <= 0) {
            throw new IllegalArgumentException();
        }
        this.fireDamage = fireDamage;
    }

    // ============ Getters ============

    public int getFireDamage() {
        return this.fireDamage;
    }

    // ============ Override from Monster ============

    // Dragons take half damage
    @Override
    public int takeDamage(int damage) {
        int dmgTaken = Math.min(damage / 2, this.hitPoints);
        this.hitPoints -= dmgTaken;
        return dmgTaken;
    }

    // Implement abstract method - Dragons deal strength + fire damage
    @Override
    public int attack(Monster other) {
        int res = other.takeDamage(this.strength + this.fireDamage);
        return res;
    }
}
