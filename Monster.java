// TOPIC: Abstract Classes, Abstract Methods, Protected Fields

public abstract class Monster {
    protected String name;
    protected int hitPoints;
    protected int strength;

    public Monster(String name, int hitPoints, int strength) {
        if (hitPoints <= 0 || strength <= 0) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
    }

    public String getName() {
        return this.name;
    }

    public int getHitPoints() {
        return this.hitPoints;
    }

    public boolean isAlive() {
        return this.hitPoints != 0;
    }

    public int getStrength() {
        return this.strength;
    }

    // Concrete method - can be overridden by subclasses
    public int takeDamage(int damage) {
        int dmgTaken = Math.min(damage, this.hitPoints);
        this.hitPoints -= dmgTaken;
        return dmgTaken;
    }

    // Abstract method - MUST be implemented by concrete subclasses
    public abstract int attack(Monster other);
}
