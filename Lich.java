// TOPIC: Multi-level inheritance + implementing Interface
// Monster -> Zombie -> Lich
// Lich also implements Magical interface
// This shows a class can EXTEND another class AND IMPLEMENT an interface

public class Lich extends Zombie implements Magical {
    private int mana;

    public Lich(String name, int hitPoints, int strength, int poisonDamage, int mana) {
        super(name, hitPoints, strength, poisonDamage);
        if (mana < 0) {
            throw new IllegalArgumentException();
        }
        this.mana = mana;
    }

    // ============ Magical Interface Implementation ============

    @Override
    public int castSpell(Monster target) {
        if (!hasMana()) {
            return 0;
        }
        this.mana -= 1;
        return target.takeDamage(this.spell());
    }

    @Override
    public int getMana() {
        return this.mana;
    }

    @Override
    public boolean hasMana() {
        return this.mana > 0;
    }

    @Override
    public void restoreMana(int amount) {
        this.mana += amount;
    }

    // ============ Override from Zombie ============

    // Lich prefers magic (80% chance) over physical attack
    @Override
    public int attack(Monster other) {
        if (didMagicAttack()) {
            return castSpell(other);
        }
        return super.attack(other);  // Falls back to Zombie attack
    }

    // Lich has 25% dodge chance (unlike regular Zombie)
    @Override
    public int takeDamage(int damage) {
        if (this.didDodge()) {
            return 0;
        }
        return super.takeDamage(damage);
    }

    // ============ Lich-specific Methods ============

    public int spell() {
        return (int)(Math.random() * 6 + 1) + super.getStrength() + super.getPoisonDamage();
    }

    public boolean didMagicAttack() {
        return Math.random() < 0.8 && this.hasMana();
    }

    public boolean didDodge() {
        return Math.random() < 0.25;
    }
}
