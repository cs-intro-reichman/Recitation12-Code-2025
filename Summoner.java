// TOPIC: Multi-level inheritance with interface
// Summoner extends Mage (which implements Magical)
// Monster -> Mage -> Summoner
// Summoner can drain life with spells and summon creatures

public class Summoner extends Mage {
    Dragon [] summonedDragons;
    int dragonCount;

    public Summoner(String name, int hitPoints, int strength, int mana, int spellPower) {
        super(name, hitPoints, strength, mana, spellPower);
        this.summonedDragons = new Dragon[30];
        this.dragonCount = 0;
    }

    // Override castSpell - heals based on damage dealt
    @Override
    public int castSpell(Monster target) {
        int damage = super.castSpell(target);
        return damage;
    }

    // Summoner can summon creatures (just prints for demo)
    public void summonDragon() {
        if (this.getMana() >= 2 && dragonCount < summonedDragons.length) {
            this.mana -= 2;
            Dragon dragon = new Dragon("Summoned Dragon", 50, 15, 10);
            summonedDragons[dragonCount] = dragon;
            dragonCount++;
        }
    }


}
