import java.util.*;

public class annapurna {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, List<String>> storesAndItems = new HashMap<>();

        while (!"END".equals(input)) {
            String[] data = input.split("->");
            String command = data[0];
            String shop = data[1];

            switch (command) {
                case "Add":
                    String[] Items = data[2].split(",");
                    storesAndItems.putIfAbsent(shop, new ArrayList<>());
                    for (int i = 0; i < Items.length; i++) {
                        storesAndItems.get(shop).add(Items[i]);
                    }


                    break;

                case "Remove":
                    storesAndItems.remove(shop);
                    break;
            }


            input = scanner.nextLine();
        }
        System.out.println("Stores list:");

        storesAndItems.entrySet().stream().sorted((store1, store2) -> {
            int result = Integer.compare(store2.getValue().size(), store1.getValue().size());

            if (result == 0) {
                result = store2.getKey().compareTo(store1.getKey());

            }
            return result;
        }).forEach(entry -> {
            System.out.printf("%s\n", entry.getKey());
            for (String s : entry.getValue()) {
                System.out.println(String.format("<<%s>>", s));

            }
        });


    }
}
