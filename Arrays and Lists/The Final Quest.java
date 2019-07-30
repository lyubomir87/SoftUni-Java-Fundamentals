import java.util.*;
import java.util.stream.Collectors;

public class finalQuest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> words = Arrays.stream(scanner.nextLine().split(" ")).
                collect(Collectors.toCollection(ArrayList::new));
        String input = scanner.nextLine();

        while (!"Stop".equals(input)) {
            String[] elements = input.split(" ");
            String command = elements[0];

            switch (command) {
                case "Delete":
                    int index = Integer.parseInt(elements[1]);
                    if (index >= -1 && index < words.size() - 1) {
                        words.remove(index + 1);
                    }

                    break;

                case "Swap":
                    String first = elements[1];
                    String second = elements[2];
                    int index1 = words.indexOf(first);
                    int index2 = words.indexOf(second);
                    if (words.contains(first)) {
                        if (words.contains(second)) {
                            words.remove(index1);
                            words.add(index1, second);
                            words.remove(index2);
                            words.add(index2, first);
                        }
                    }

                    break;
                case "Put":
                    String putWord = elements[1];
                    int index3 = Integer.parseInt(elements[2]);
                    if (index3 > 0 && index3 <= words.size() + 1) {
                        words.add(index3 - 1, putWord);
                    }
                    break;
                case "Sort":
                    Collections.sort(words, Collections.reverseOrder());
                    break;

                case "Replace":
                    String third = elements[1];
                    String forth = elements[2];

                    int index4 = words.indexOf(forth);
                    if (words.contains(forth)) {
                        words.remove(index4);
                        words.add(index4, third);


                    }


            }
            input = scanner.nextLine();

        }
        for (String word : words) {
            System.out.print(word + " ");
        }
    }
}
