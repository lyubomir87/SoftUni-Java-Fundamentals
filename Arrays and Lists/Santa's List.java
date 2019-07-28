import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SantaList1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> kids = Arrays.stream(scanner.nextLine().split("&")).
                collect(Collectors.toCollection(ArrayList::new));

        String input = scanner.nextLine();

        while (!"Finished!".equals(input)) {
            String[] all = input.split(" ");
            String command = all[0];

            switch (command) {
                case "Bad":
                    if (!kids.contains(all[1]))
                        kids.add(0, all[1]);
                    break;

                case "Good":
                    kids.remove(all[1]);
                    break;

                case "Rename":
                    String[] sad = input.split(" ");
                    String first = sad[1];
                    String second = sad[2];
                    if (kids.contains(first)) {
                        int index = kids.indexOf(first);
                        kids.remove(first);
                        if (!kids.contains(second)) {
                            kids.add(index, second);
                        }
                    }

                    break;

                case "Rearrange":
                    if (kids.contains(all[1])){
                        kids.remove(all[1]);
                        kids.add(all[1]);
                    }

                    break;
            }


            input = scanner.nextLine();
        }
        for (int i = 0; i < kids.size(); i++) {
            if (i == kids.size() - 1) {
                System.out.println(kids.get(i));
            } else {
                System.out.print(kids.get(i) + ", ");
            }
        }
    }
}
