import java.util.ArrayDeque;
import java.util.Scanner;

public class browser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayDeque<String> stack = new ArrayDeque<>();
        while (!"Home".equals(input)) {
            if (!"back".equals(input)) {
                stack.push(input);
                System.out.println(stack.peek());
            } else {
                if (stack.size() > 1) {
                    stack.pop();
                    System.out.println(stack.peek());
                } else {
                    System.out.println("no previous URLs");
                }
            }


            input = scanner.nextLine();
        }
    }
}
