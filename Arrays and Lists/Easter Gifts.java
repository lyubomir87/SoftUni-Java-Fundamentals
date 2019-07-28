import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class easterGifts1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> gifts = Arrays.stream(scanner.nextLine().split(" ")).
                collect(Collectors.toCollection(ArrayList::new));
        String input = scanner.nextLine();

        while (!"No Money".equals(input)) {
            String[] gift = input.split(" ");
            String command = gift[0];

            switch (command) {
                case "OutOfStock":

                    for (int i = 0; i < gifts.size(); i++) {
                        if (gifts.contains(gift[1])) {
                            int index = gifts.indexOf(gift[1]);
                            String out = gift[1];
                            gifts.remove(out);
                            gifts.add(index, "None");
                        }


                    }
                    break;

                case "Required":
                    String g = gift[1];
                    int index = Integer.parseInt(gift[2]);
                    if (index >= 0 && index < gifts.size()) {
                        gifts.remove(index);
                        gifts.add(index, g);
                    }
                    break;

                case "JustInCase":
                    int lastIndex = gifts.size() - 1;
                    gifts.remove(lastIndex);
                    gifts.add(gift[1]);
                    break;

            }
            input = scanner.nextLine();
        }
        if (gifts.contains("None")) {
            for (int i = 0; i < gifts.size(); i++) {
                gifts.remove("None");
            }


        }

        System.out.println(String.join(" ", gifts));
    }
}
