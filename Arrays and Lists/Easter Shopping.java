import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class easter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> stores = Arrays.stream(scanner.nextLine().split(" ")).
                collect(Collectors.toCollection(ArrayList::new));

        int n = Integer.parseInt(scanner.nextLine());


        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] elements = input.split(" ");
            String command = elements[0];

            switch (command) {
                case "Include":
                    stores.add(elements[1]);
                    break;

                case "Visit":
                    if (Integer.parseInt(elements[2]) <= stores.size()) {
                        if (elements[1].equals("first")) {
                            for (int j = 0; j < Integer.parseInt(elements[2]); j++) {
                                stores.remove(0);
                            }

                        }
                        if (elements[1].equals("last")) {
                            for (int j = 0; j < Integer.parseInt(elements[2]); j++) {
                                stores.remove(stores.size() - 1);
                            }
                        }
                    }
                    break;
                case "Prefer":
                    if (Integer.parseInt(elements[1]) < stores.size() && Integer.parseInt(elements[2]) < stores.size()) {
                        int index = Integer.parseInt(elements[1]);
                        int index2 = Integer.parseInt(elements[2]);
                        String shop1 = stores.get(index);
                        String shop2 = stores.get(index2);
                        stores.remove(shop1);
                        stores.add(index, shop2);
                        stores.remove(index2);
                        stores.add(index2, shop1);
                    }
                    break;

                case "Place":
                    if (Integer.parseInt(elements[2]) >= 0 && Integer.parseInt(elements[2]) < stores.size()) {
                        String shop = elements[1];
                        int shopIndex = Integer.parseInt(elements[2]);
                        stores.add(shopIndex + 1, shop);
                    }
                    break;
            }
        }
        System.out.println("Shops left:");
        for (int i = 0; i < stores.size(); i++) {
            System.out.print(stores.get(i) + " ");

        }

    }
}
