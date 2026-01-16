public class Main {
    public static void main(String[] args) {
        
        // Method 1: Using instanceof with an object
        Summoner summoner = new Summoner("Gandalf", 100, 10, 50, 20);
        if (summoner instanceof Magical) {
            System.out.println("Summoner implements Magical");
        }

        // Method 2: Using Class.isAssignableFrom() - checks at class level
        if (Magical.class.isAssignableFrom(Summoner.class)) {
            System.out.println("Summoner class implements Magical");
        }

        Summoner summoner2 = new Summoner("Summoner 1", 30, 30, 10, 2);
    }
}