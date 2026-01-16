// TOPIC: Interface - defines a contract for magical creatures
// Interfaces describe "A can do B" relationship
// A Magical creature CAN cast spells

public interface Magical {

    int castSpell(Monster target);

    int getMana();

    boolean hasMana();

    void restoreMana(int amount);
}
