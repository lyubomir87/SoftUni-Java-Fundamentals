import java.util.Scanner;

public class Dungeon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int health = 100;
        int coins = 0;
        int bestRoom = 0;
        String[] enemy = scanner.nextLine().split("\\|");

        for (int i = 0; i < enemy.length; i++) {
            String[] elements = enemy[i].split("\\s+");

            String command = elements[0];


            if ("potion".equals(command)) {
                bestRoom++;
                int healthEarned = Integer.parseInt(elements[1]);
                if (health + healthEarned >= 100) {

                    healthEarned = 100 - health;
                    health = 100;
                    System.out.println("You healed for " + healthEarned + " hp.");
                    System.out.printf("Current health: %d hp.\n", health);
                } else if (health < 100) {
                    health += healthEarned;
                    System.out.println("You healed for " + healthEarned + " hp.");
                    System.out.printf("Current health: %d hp.\n", health);
                }
            }
            if ("chest".equals(command)) {
                bestRoom++;
                int coinsEarned = Integer.parseInt(elements[1]);
                coins += coinsEarned;
                System.out.printf("You found %d coins.\n", coinsEarned);
            }
            if (!"potion".equals(command) && !"chest".equals(command)) {
                bestRoom++;
                int monsterAttack = Integer.parseInt(elements[1]);
                health -= monsterAttack;
                if (health > 0) {
                    System.out.printf("You slayed %s.\n", command);
                } else {
                    System.out.printf("You died! Killed by %s.\n", command);
                    System.out.printf("Best room: %d", bestRoom);
                    return;
                }
            }
        }
        if (health > 0) {
            System.out.println("You've made it!");
            System.out.printf("Coins: %d\n", coins);
            System.out.printf("Health: %d", health);
        }
    }
}
