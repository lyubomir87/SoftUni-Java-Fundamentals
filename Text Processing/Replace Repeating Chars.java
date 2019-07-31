import java.util.Scanner;

public class replaceRepeat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        text = text.replaceAll("(.)\\1+", "$1");

        System.out.println(text);
    }
}
