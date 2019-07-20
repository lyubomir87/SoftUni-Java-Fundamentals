import java.util.*;

public class practiceSession {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, List<String>> mapAndName = new HashMap<>();

        while (!"END".equals(input)) {
            String[] data = input.split("->");
            String command = data[0];
            String road = data[1];
            
            switch (command) {
                case "Add":

                    mapAndName.putIfAbsent(road, new ArrayList<>());
                    mapAndName.get(road).add(data[2]);
                    break;

                case "Move":
                    if (mapAndName.get(road).contains(data[2])) {
                        mapAndName.get(road).remove(data[2]);
                        mapAndName.get(data[3]).add(data[2]);
                    }
                    break;

                case "Close":
                    mapAndName.remove(road);

                    break;
            }


            input = scanner.nextLine();
        }
        System.out.println("Practice sessions:");
        mapAndName.entrySet()
                .stream()
                .sorted((racer1, racer2) -> {
                    int sort = Integer.compare(racer2.getValue().size(), racer1.getValue().size());
                    if (sort == 0) {
                        sort = racer1.getKey().compareTo(racer2.getKey());
                    }
                    return sort;
                }).forEach(racer -> {
            System.out.printf("%s%n", racer.getKey());
            for (String s : racer.getValue()) {
                System.out.printf("++%s%n", s);
            }
        });
    }
}
