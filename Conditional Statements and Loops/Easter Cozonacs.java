import java.util.Scanner;

public class cozonac {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        double priceFloorKg = Double.parseDouble(scanner.nextLine());
        double eggsPrice = priceFloorKg * 0.75;
        double milkPrice = (priceFloorKg * 1.25) / 4;
        double cozunacPrice = priceFloorKg + eggsPrice + milkPrice;
        int cozonacCount = 1;
        int eggsCount = 0;
        while (budget >= cozunacPrice) {
            budget -= cozunacPrice;

            if (cozonacCount % 3 == 0) {
                eggsCount -= cozonacCount - 2;
            }

            cozonacCount++;
            eggsCount += 3;

        }
        System.out.printf("You made %d cozonacs! Now you have %d eggs and %.2fBGN left.", cozonacCount - 1, eggsCount, budget);
    }
}
