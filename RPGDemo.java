// TOPIC: Demonstrating Polymorphism, Inheritance, Composition, and Interfaces

public class RPGDemo {

    public static void main(String[] args) {

        // ============================================================
        // CREATING MONSTERS - Basic Inheritance
        // ============================================================

        Dragon smaug = new Dragon("Smaug", 200, 30, 50);
        Zombie walker = new Zombie("Walker", 50, 10, 5);
        Vampire dracula = new Vampire("Dracula", 100, 25);

        // ============================================================
        // MULTI-LEVEL INHERITANCE
        // Monster -> Vampire -> VampireKing
        // Monster -> Zombie -> Lich
        // ============================================================

        VampireKing vlad = new VampireKing("Vlad", 150, 35);
        Lich lichKing = new Lich("Kel'Thuzad", 80, 15, 10, 20);

        // ============================================================
        // COMPOSITION EXAMPLE
        // DragonKnight HAS-A Knight and HAS-A Dragon
        // ============================================================

        Knight arthur = new Knight("Arthur", 100, 20, 10, TitleEnum.SIR);
        Dragon falkor = new Dragon("Falkor", 150, 25, 30);
        DragonKnight heroUnit = new DragonKnight(arthur, falkor);

        // ============================================================
        // INTERFACE: Magical
        // Mage and Lich both implement Magical
        // ============================================================

        Mage gandalf = new Mage("Gandalf", 80, 10, 30, 40);
        Summoner elara = new Summoner("Elara", 120, 15, 50, 45);

        // ============================================================
        // POLYMORPHISM WITH ABSTRACT CLASS
        // All can be treated as Monster
        // ============================================================

        System.out.println("=== ALL MONSTERS (Polymorphism with Abstract Class) ===");
        Monster[] allMonsters = {smaug, walker, dracula, vlad, lichKing, heroUnit, gandalf, elara};

        for (Monster m : allMonsters) {
            System.out.println(m.getName() + " - HP: " + m.getHitPoints() + ", Strength: " + m.getStrength());
        }
        System.out.println();

        // ============================================================
        // POLYMORPHISM WITH INTERFACE
        // Magical creatures can be grouped together
        // ============================================================

        System.out.println("=== MAGICAL CREATURES (Polymorphism with Interface) ===");
        Magical[] magicals = {gandalf, elara, lichKing};

        for (Magical m : magicals) {
            System.out.println("Mana: " + m.getMana() + ", Has Mana: " + m.hasMana());
        }
        System.out.println();

        // ============================================================
        // BATTLE DEMONSTRATION
        // Shows how different monsters attack differently
        // ============================================================

        System.out.println("=== BATTLE DEMONSTRATION ===");

        // Dragon vs Zombie
        System.out.println("\n--- Dragon attacks Zombie ---");
        System.out.println("Zombie HP before: " + walker.getHitPoints());
        int damage = smaug.attack(walker);
        System.out.println("Damage dealt: " + damage);
        System.out.println("Zombie HP after: " + walker.getHitPoints());

        // Reset zombie for next demo
        walker = new Zombie("Walker", 50, 10, 5);

        // Vampire attacks (and heals)
        System.out.println("\n--- Vampire attacks Zombie (with lifesteal) ---");
        System.out.println("Vampire HP before: " + dracula.getHitPoints());
        System.out.println("Zombie HP before: " + walker.getHitPoints());
        damage = dracula.attack(walker);
        System.out.println("Damage dealt: " + damage);
        System.out.println("Vampire HP after: " + dracula.getHitPoints());
        System.out.println("Zombie HP after: " + walker.getHitPoints());

        // Mage casts spell
        System.out.println("\n--- Mage casts spell ---");
        System.out.println("Mage mana before: " + gandalf.getMana());
        Monster target = new Dragon("Target", 100, 10, 10);
        damage = gandalf.castSpell(target);
        System.out.println("Spell damage: " + damage);
        System.out.println("Mage mana after: " + gandalf.getMana());

        // ============================================================
        // COMPOSITION DEMONSTRATION
        // DragonKnight uses both Knight and Dragon abilities
        // ============================================================

        System.out.println("\n=== COMPOSITION DEMONSTRATION ===");
        System.out.println("DragonKnight name: " + heroUnit.getName());
        System.out.println("DragonKnight attacks with both Knight and Dragon!");
        Monster enemy = new Zombie("Enemy", 200, 10, 5);
        System.out.println("Enemy HP before: " + enemy.getHitPoints());
        damage = heroUnit.attack(enemy);
        System.out.println("Total damage dealt: " + damage);
        System.out.println("Enemy HP after: " + enemy.getHitPoints());

        // ============================================================
        // INHERITANCE CHAIN DEMONSTRATION
        // ============================================================

        System.out.println("\n=== INHERITANCE CHAIN DEMONSTRATION ===");

        System.out.println("Lich inherits from Zombie which inherits from Monster:");
        System.out.println("  Name (from Monster): " + lichKing.getName());
        System.out.println("  Strength (from Monster): " + lichKing.getStrength());
        System.out.println("  Poison Damage (from Zombie): " + lichKing.getPoisonDamage());
        System.out.println("  Mana (from Magical interface): " + lichKing.getMana());

        System.out.println("\nSummoner inherits from Mage which inherits from Monster:");
        System.out.println("  Name (from Monster): " + elara.getName());
        System.out.println("  Mana (from Mage/Magical): " + elara.getMana());
        System.out.println("  Spell Power (from Mage): " + elara.getSpellPower());
    }
}
