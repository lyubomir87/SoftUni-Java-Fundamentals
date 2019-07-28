import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HelloFrance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] elements = scanner.nextLine().split("\\|");
        double budget = Double.parseDouble(scanner.nextLine());
        double maxClothes = 50.00;
        double maxShoes = 35.00;
        double maxAccessories = 20.50;
        double oldPrice = 0.0;
        double newPrice = 0.0;
        double setPrice = 0.0;
        int tickets = 150;

        List<Double> prices = new ArrayList<>();

        for (int i = 0; i < elements.length; i++) {
            String[] data = elements[i].split("->");
            String command = data[0];
            double spent = Double.parseDouble(data[1]);

            switch (command) {

                case "Clothes":

                    if (spent <= maxClothes && spent <= budget) {
                        budget -= spent;
                        oldPrice += spent;
                        newPrice += spent + spent * 0.40;
                        setPrice = spent + spent * 0.40;
                        prices.add(setPrice);

                    }

                    break;

                case "Shoes":

                    if (spent <= maxShoes && spent <= budget) {
                        budget -= spent;
                        oldPrice += spent;
                        newPrice += spent + spent * 0.40;
                        setPrice = spent + spent * 0.40;
                        prices.add(setPrice);

                    }
                    break;

                case "Accessories":

                    if (spent <= maxAccessories && spent <= budget) {
                        budget -= spent;
                        oldPrice += spent;
                        newPrice += spent + spent * 0.40;
                        setPrice = spent + spent * 0.40;
                        prices.add(setPrice);

                    }

                    break;
            }

        }
        budget += newPrice;
        double profit = newPrice - oldPrice;

        prices.
                stream()
                .forEach(e ->
                        System.out.printf("%.2f" + " ", e));


        System.out.println();

        System.out.printf("Profit: %.2f\n", profit);

        if (budget >= tickets) {
            System.out.println("Hello, France!");
        } else {
            System.out.println("Time to go.");
        }

    }
}
