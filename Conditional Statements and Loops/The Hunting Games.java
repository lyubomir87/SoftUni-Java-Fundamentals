import java.util.Scanner;

public class huntingGames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        int playersCount = Integer.parseInt(scanner.nextLine());
        double groupsEnergy = Double.parseDouble(scanner.nextLine());
        double waterPerDayPerson = Double.parseDouble(scanner.nextLine());
        double foodPerDayPerson = Double.parseDouble(scanner.nextLine());
        double totalWater = days * playersCount * waterPerDayPerson;
        double totalFood = days * playersCount * foodPerDayPerson;

        for (int i = 1; i <= days; i++) {
            double energyLoss = Double.parseDouble(scanner.nextLine());
            groupsEnergy -= energyLoss;
            if (groupsEnergy <= 0) {
                break;
            }
            if (i % 2 == 0) {
                groupsEnergy += groupsEnergy * 0.05;
                totalWater -= totalWater * 0.30;
            }
            if (i % 3 == 0) {
                totalFood -= totalFood / playersCount;
                groupsEnergy += groupsEnergy * 0.10;
            }
        }
        if (groupsEnergy > 0) {
            System.out.printf("You are ready for the quest. You will be left with - %.2f energy!", groupsEnergy);
        } else {
            System.out.printf("You will run out of energy. You will be left with %.2f food and %.2f water.", totalFood, totalWater);
        }
    }
}
