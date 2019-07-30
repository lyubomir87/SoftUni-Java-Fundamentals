import java.util.Scanner;

public class party {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int partySize = Integer.parseInt(scanner.nextLine());
        int days = Integer.parseInt(scanner.nextLine());
        int coins = 0;
        for (int i = 1; i <= days; i++) {

            if (i % 10 == 0) {
                partySize -= 2;
            }
            if (i % 15 == 0) {
                partySize += 5;
            }
            coins += 50 - (partySize) * 2;
            if (i % 3 == 0) {
                coins -= partySize * 3;
            }

            if (i % 5 == 0) {
                coins += partySize * 20;
                if (i % 3 == 0) {
                    coins -= partySize * 2;
                }
            }


        }
        int totalCoin = coins / partySize;
        System.out.printf("%s companions received %d coins each.", partySize, totalCoin);
    }
}
