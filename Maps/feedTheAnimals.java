import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class feedAnimals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Integer> animalNameAndFood = new HashMap<>();
        Map<String, Integer> areaCount = new LinkedHashMap<>();
        while (!"Last Info".equals(input)) {
            String[] data = input.split(":");
            String command = data[0];
            String name = data[1];
            int food = Integer.parseInt(data[2]);
            String area = data[3];

            switch (command) {
                case "Add":
                    if (!animalNameAndFood.containsKey(name)) {
                        animalNameAndFood.put(name, food);


                        if (!areaCount.containsKey(area)) {
                            areaCount.put(area, 1);
                        } else {
                            int current = areaCount.get(area) + 1;
                            areaCount.put(area, current);
                        }


                    } else {
                        int addFood = animalNameAndFood.get(name) + food;
                        animalNameAndFood.put(name, addFood);
                    }
                    break;

                case "Feed":
                    if (animalNameAndFood.containsKey(name)) {
                        int old = animalNameAndFood.get(name) - food;
                        animalNameAndFood.put(name, old);
                        if (old <= 0) {
                            int currArea = areaCount.get(area) - 1;
                            animalNameAndFood.remove(name);
                            areaCount.put(area, currArea);

                            System.out.printf("%s was successfully fed\n", name);
                        }
                    }
                    break;
            }
            areaCount.remove(area, 0);

            input = scanner.nextLine();
        }
        System.out.println("Animals:");
        animalNameAndFood.entrySet().stream().sorted((a, b) -> {
            int result = b.getValue().compareTo(a.getValue());
            if (result == 0) {
                result = a.getKey().compareTo(b.getKey());
            }
            return result;
        }).forEach(entry ->
                System.out.println(String.format("%s -> %dg", entry.getKey(), entry.getValue())));


        System.out.println("Areas with hungry animals:");


        areaCount.entrySet().stream().sorted((a, b) -> b.getValue().compareTo(a.getValue())).
                forEach(entry ->
                        System.out.println(String.format("%s : %d", entry.getKey(), entry.getValue())));


    }
}
