import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class task {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> tasks = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt)
                .collect(Collectors.toList());
        String input = scanner.nextLine();
        int completeCount = 0;
        int incompleteCount = 0;
        int droppedCount = 0;
        while (!"End".equals(input)) {
            String[] data = input.split("\\s+");
            String command = data[0];

            switch (command) {
                case "Complete":
                    int index = Integer.parseInt(data[1]);
                    if (index >= 0 && index < tasks.size()) {
                        tasks.get(index);
                        tasks.set(index, 0);
                    }
                    break;

                case "Change":
                    int changeIndex = Integer.parseInt(data[1]);
                    int time = Integer.parseInt(data[2]);
                    if (changeIndex >= 0 && changeIndex < tasks.size()) {
                        tasks.get(changeIndex);
                        tasks.set(changeIndex, time);
                    }
                    break;

                case "Drop":
                    int dropIndex = Integer.parseInt(data[1]);
                    if (dropIndex >= 0 && dropIndex < tasks.size()) {
                        tasks.get(dropIndex);
                        tasks.set(dropIndex, -1);
                    }
                    break;

                case "Count":
                    switch (data[1]) {
                        case "Completed":
                            for (int i = 0; i < tasks.size(); i++) {
                                if (tasks.get(i) == 0) {
                                    completeCount++;
                                }

                            }
                            System.out.println(completeCount);
                            break;

                        case "Incomplete":
                            for (int i = 0; i < tasks.size(); i++) {
                                if (tasks.get(i) > 0) {
                                    incompleteCount++;
                                }
                            }
                            System.out.println(incompleteCount);
                            break;

                        case "Dropped":

                            for (int i = 0; i < tasks.size(); i++) {
                                if (tasks.get(i) < 0) {
                                    droppedCount++;
                                }
                            }
                            System.out.println(droppedCount);
                            break;
                    }
                    break;
            }


            input = scanner.nextLine();
        }
        for (Integer task : tasks) {
            if (task > 0) {
                System.out.print(task + " ");
            }
        }
    }
}
