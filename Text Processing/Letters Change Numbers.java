import java.util.Scanner;

public class lettersChange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split("\\s+");

        double sum = 0;
        for (String string : strings) {
            char before = string.charAt(0);
            char after = string.charAt(string.length() - 1);

            long number = Long.parseLong(string.substring(1, string.length() - 1));
            sum += calcCurrent(before, after, number);
        }
        System.out.printf("%.2f", sum);
    }

    private static double calcCurrent(char before, char after, long number) {
        double value = 0;
        if (Character.isUpperCase(before)) {
            value += number * 1.00 / (before - 'A' + 1) * 1.00;

        } else {
            value += number * (before - 'a' + 1);

        }
        if (Character.isUpperCase(after)) {
            value -= (after - 'A' + 1);

        } else {
            value += (after - 'a' + 1);

        }
        return value;
    }
}
