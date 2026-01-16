// TOPIC: Multi-level inheritance (Monster -> Vampire -> VampireKing)
// VampireKing has 20% chance to attack twice and 43.75% dodge (tries twice)

public class VampireKing extends Vampire {

    // ============ Constructor ============

    public VampireKing(String name, int hitPoints, int strength) {
        super(name, hitPoints, strength);
    }

    // ============ Override from Vampire ============

    // 20% chance to attack twice
    @Override
    public int attack(Monster other) {
        int res = super.attack(other);
        if (this.didDoubleAttack()) {
            res += super.attack(other);
        }
        return res;
    }

    // Tries to dodge twice (43.75% total dodge chance)
    @Override
    public int takeDamage(int damage) {
        if (super.didDodge()) {
            return 0;
        }
        return super.takeDamage(damage);
    }

    // ============ VampireKing-specific Methods ============

    public boolean didDoubleAttack() {
        return Math.random() < 0.2;
    }
}
