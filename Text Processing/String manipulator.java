import java.util.Scanner;

public class manipulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String word = "";

        while (!"End".equals(input)) {
            String[] data = input.split("\\s+");
            String command = data[0];

            switch (command) {
                case "Add":
                    word += data[1];


                    break;

                case "Upgrade":
                    String ch1 = data[1];
                    String newResult = "";
                    for (int i = 0; i < word.length(); i++) {
                        if (String.valueOf(word.charAt(i)).equals(ch1)) {
                            newResult += (char) (word.charAt(i) + 1);
                        } else {
                            newResult += String.valueOf(word.charAt(i));
                        }
                    }
                    word = newResult;
                    break;



                case "Print":
                    System.out.println(word);
                    break;

                case "Index":
                    if (word.contains(data[1])) {
                        for (int i = -1; (i = word.indexOf(data[1], i)) != -1; i++) {
                            System.out.print(i + " ");

                        }
                        System.out.println();
                    } else {
                        System.out.println("None");
                    }


                    break;

                case "Remove":

                    word = word.replace(data[1], "");

                    break;
            }


            input = scanner.nextLine();
        }
    }
}
