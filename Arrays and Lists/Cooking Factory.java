import java.util.Scanner;

public class cooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] batch = scanner.nextLine().split("#");
        String[] saveBatch = new String[batch.length];

        double biggestSum = -1000000000.0;
        double averageSum = 0.0;
        int saveLength = 0;

        while (!"Bake It!".equals(batch[0])) {

            double sum = 0.0;
            for (int i = 0; i < batch.length; i++) {
                int quality = Integer.parseInt(batch[i]);
                sum += quality;

            }
            if (biggestSum < sum) {
                biggestSum = sum;
                averageSum = biggestSum * 1.0 / batch.length * 1.0;
                saveBatch = batch;
                saveLength = batch.length;
            } else if (biggestSum == sum) {
                if (averageSum < sum / batch.length) {
                    averageSum = sum / batch.length;
                    saveBatch = batch;

                } else if (averageSum == sum / batch.length) {
                    if (batch.length < saveLength) {
                        saveBatch = batch;
                    }

                }
            }
            batch = scanner.nextLine().split("#");
        }
        System.out.printf("Best Batch quality: %.0f%n", biggestSum);
        System.out.println(String.join(" ", saveBatch));
    }
}

