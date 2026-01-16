// TOPIC: Class that extends Monster AND implements Magical interface
// Mage IS-A Monster (inheritance) and CAN DO magic (interface)

public class Mage extends Monster implements Magical {
    protected int mana;
    protected int spellPower;

    public Mage(String name, int hitPoints, int strength, int mana, int spellPower) {
        super(name, hitPoints, strength);
        if (mana < 0 || spellPower <= 0) {
            throw new IllegalArgumentException();
        }
        this.mana = mana;
        this.spellPower = spellPower;
    }

    // ============ Magical Interface Implementation ============

    @Override
    public int castSpell(Monster target) {
        if (!hasMana()) {
            return 0;
        }
        this.mana -= 1;
        int damage = this.spellPower + (int)(Math.random() * 6 + 1);
        return target.takeDamage(damage);
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

    // ============ Monster Abstract Method Implementation ============

    // Mage prefers spells (80% chance) but can do physical attack
    @Override
    public int attack(Monster other) {
        if (this.shouldCastSpell() && hasMana()) {
            return castSpell(other);
        }
        return other.takeDamage(this.strength);
    }

    // ============ Additional Methods ============
    public boolean shouldCastSpell() {
        return Math.random() < 0.8;
    }

    public int getSpellPower() {
        return this.spellPower;
    }
}
