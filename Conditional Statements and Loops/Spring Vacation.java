import java.util.Scanner;

public class SpringVacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int daysOfTrip = Integer.parseInt(scanner.nextLine());
        double budget = Double.parseDouble(scanner.nextLine());
        int groupOfPeople = Integer.parseInt(scanner.nextLine());
        double priceForFuelKm = Double.parseDouble(scanner.nextLine());
        double foodPerPerson = Double.parseDouble(scanner.nextLine());
        double priceForRoomNight = Double.parseDouble(scanner.nextLine());

        double foodExpenses = foodPerPerson * daysOfTrip * groupOfPeople;
        double hotelTotalPrice = daysOfTrip * groupOfPeople * priceForRoomNight;
        if (groupOfPeople > 10) {
            hotelTotalPrice = hotelTotalPrice - (hotelTotalPrice) * 0.25;
        }

        double consumedFuel = 0.0;
        double moneyReceive = 0.0;

        double totalExpense = foodExpenses + hotelTotalPrice;
        for (int i = 1; i <= daysOfTrip; i++) {
            double travveledDistance = Double.parseDouble(scanner.nextLine());
            consumedFuel = travveledDistance * priceForFuelKm;
            totalExpense += consumedFuel;
            if (i % 3 == 0 || i % 5 == 0) {
                totalExpense += totalExpense * 0.40;
            }
            if (i % 7 == 0) {
                moneyReceive = totalExpense / groupOfPeople;
                totalExpense -= moneyReceive;
            }
            if (budget < totalExpense) {
                break;
            }
        }

        if (budget >= totalExpense) {

            System.out.printf("You have reached the destination. You have %.2f$ budget left.", budget - totalExpense);
        } else {
            System.out.printf("Not enough money to continue the trip. You need %.2f$ more.", totalExpense - budget);
        }
    }
}
