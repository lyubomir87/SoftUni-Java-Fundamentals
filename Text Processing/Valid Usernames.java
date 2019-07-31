import java.util.*;


public class validUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] array = scanner.nextLine().split(", ");
        for (int i = 0; i < array.length; i++) {
            if (isUsernameValid(array[i])) {
                System.out.println(array[i]);
            }
        }
    }

    static boolean isUsernameValid(String username) {

        if (username.length() >= 3 && username.length() <= 16) {
            for (int i = 0; i < username.length(); i++) {
                char ch = username.charAt(i);
                if (!(Character.isLetter(ch) || Character.isDigit(ch)
                        || ch == '-' || ch == '_')) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }
}
