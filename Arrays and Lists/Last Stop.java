import java.util.*;
import java.util.stream.Collectors;

public class LastStop1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> paintings = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toCollection(ArrayList::new));

        String input = scanner.nextLine();

        while (!"END".equals(input)) {

            String[] data = input.split("\\s+");

            String command = data[0];

            switch (command) {
                case "Change":

                    String paint2 = data[2];

                    int index = paintings.indexOf(data[1]);
                    if (paintings.contains(data[1])) {
                        paintings.set(index, paint2);


                    }
                    break;

                case "Hide":
                    paintings.remove(data[1]);
                    break;

                case "Switch":
                    String word1 = data[1];
                    String word2 = data[2];
                    int index1 = paintings.indexOf(word1);
                    int index2 = paintings.indexOf(word2);
                    if (paintings.contains(data[1])) {
                        if (paintings.contains(data[2])) {
                            paintings.remove(index1);
                            paintings.add(index1, word2);
                            paintings.remove(index2);
                            paintings.add(index2, word1);

                        }
                    }
                    break;

                case "Insert":
                    int index3 = Integer.parseInt(data[1]);

                    if (index3 >= 0 && index3 < paintings.size()) {
                        paintings.add(index3 + 1, data[2]);
                    }
                    break;

                case "Reverse":
                    Collections.reverse(paintings);

                    break;
            }


            input = scanner.nextLine();
        }

        paintings
                .stream()
                .forEach(e ->
                        System.out.print(e + " "));
    }
}
