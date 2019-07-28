import java.util.ArrayList;
import java.util.Scanner;

public class seizeFire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] fire = scanner.nextLine().split("#");
        int water = Integer.parseInt(scanner.nextLine());
        double effort = 0;
        int totalFire = 0;

        ArrayList<Integer> strukture = new ArrayList<>();
        for (int i = 0; i < fire.length; i++) {
            String[] elements = fire[i].split(" = ");
            String command = elements[0];
            // int range1 = Integer.parseInt(elements[1]);
            switch (command) {
                case "High":
                    int highRange = Integer.parseInt(elements[1]);
                    if (water < highRange) {
                        break;
                    }


                    if (highRange >= 81 && highRange <= 125) {
                        water -= highRange;
                        effort += highRange * 0.25;
                        totalFire += highRange;
                        strukture.add(highRange);
                    }
                    break;

                case "Medium":
                    int mediumRange = Integer.parseInt(elements[1]);
                    if (water < mediumRange) {
                        break;
                    }
                    if (mediumRange >= 51 && mediumRange <= 80) {
                        water -= mediumRange;
                        effort += mediumRange * 0.25;
                        totalFire += mediumRange;
                        strukture.add(mediumRange);
                    }
                    break;

                case "Low":
                    int lowRange = Integer.parseInt(elements[1]);
                    if (water < lowRange) {
                        break;
                    }
                    if (lowRange >= 1 && lowRange <= 50) {
                        water -= lowRange;
                        effort += lowRange * 0.25;
                        totalFire += lowRange;
                        strukture.add(lowRange);
                    }
                    break;

            }


        }
        System.out.print("Cells: ");
        System.out.println();
        for (Integer struktures : strukture) {


            System.out.println(" - " + struktures);

        }
        System.out.printf("Effort: %.2f\n", effort);
        System.out.printf("Total Fire: %d", totalFire);
    }
}
