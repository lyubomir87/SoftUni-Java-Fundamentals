import java.util.ArrayDeque;
import java.util.Scanner;

public class calc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        ArrayDeque<String> stack = new ArrayDeque<>();

        for (int i = input.length - 1; i >= 0; i--) {
            stack.push(input[i]);
        }
        while (stack.size() > 1) {
            int num1 = Integer.parseInt(stack.pop());
            String op = stack.pop();
            int num2 = Integer.parseInt(stack.pop());

            if (op.equals("+")) {
                stack.push(num1 + num2 + "");
            } else {
                stack.push(num1 - num2 + "");
            }
        }
        System.out.println(stack.peek());
    }
}
