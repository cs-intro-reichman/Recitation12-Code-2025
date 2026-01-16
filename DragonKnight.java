// TOPIC: Composition vs Inheritance
// DragonKnight IS-A Monster (inheritance)
// DragonKnight HAS-A Knight and HAS-A Dragon (composition)

public class DragonKnight extends Monster {
    private Knight knight;
    private Dragon dragon;

    public DragonKnight(Knight knight, Dragon dragon) {
        super(knight.getName() + " the brave and " + dragon.getName(),
              Math.min(knight.hitPoints, dragon.hitPoints),
              knight.getStrength() + dragon.getStrength());
        this.knight = knight;
        this.dragon = dragon;
    }

    // Uses both Knight's defense and Dragon's damage reduction
    @Override
    public int takeDamage(int damage) {
        int damageTaken = (damage - this.knight.getDefense()) / 2;
        if (damageTaken < 0) {
            damageTaken = 0;
        }
        damageTaken = super.takeDamage(damageTaken);
        this.knight.takeDamage(damage);
        this.dragon.takeDamage(damage);
        return damageTaken;
    }

    // Both Knight and Dragon attack
    @Override
    public int attack(Monster other) {
        int res = this.knight.attack(other);
        res += this.dragon.attack(other);
        return res;
    }

    @Override
    public boolean isAlive() {
        return this.hitPoints != 0 && this.knight.isAlive() && this.dragon.isAlive();
    }

    public Knight getKnight() {
        return this.knight;
    }

    public Dragon getDragon() {
        return this.dragon;
    }
}
