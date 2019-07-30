import java.util.Scanner;

public class cookingMasterclass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());
        double flourPricePack = Double.parseDouble(scanner.nextLine());
        double eggPrice = Double.parseDouble(scanner.nextLine());
        double apronPrice = Double.parseDouble(scanner.nextLine());
        int freePacks = students / 5;
        double totalPrice = apronPrice * Math.ceil(students * 1.20) + eggPrice * 10 * (students) + flourPricePack * (students - freePacks);
        if (budget >= totalPrice) {
            System.out.printf("Items purchased for %.2f$.", totalPrice);
        } else {
            System.out.printf("%.2f$ more needed.", totalPrice - budget);
        }

    }
}
