import java.util.*;
import java.util.stream.Collectors;

public class contacts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<String> contacts = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        String[] data = scanner.nextLine().split("\\s+");
        while (!"Print".equals(data[0])) {


            String command = data[0];

            switch (command) {
                case "Add":
                    String contactName = data[1];
                    int index = Integer.parseInt(data[2]);
                    if (!contacts.contains(contactName)) {
                        contacts.add(contactName);
                    } else {
                        if (index >= 0 && index < contacts.size()) {
                            contacts.add(index, contactName);
                        }
                    }
                    break;

                case "Remove":
                    int removeIndex = Integer.parseInt(data[1]);
                    if (removeIndex >= 0 && removeIndex < contacts.size()) {
                        contacts.remove(removeIndex);
                    }
                    break;

                case "Export":
                    int startIndex = Integer.parseInt(data[1]);
                    int count = Integer.parseInt(data[2]);
                    int endIndex = 0;
                    if (startIndex + count >= contacts.size()) {
                        endIndex = contacts.size();
                    } else {
                        endIndex = startIndex + count;
                    }
                    String export = "";
                    for (int i = startIndex; i < endIndex; i++) {
                        export += contacts.get(i) + " ";

                    }
                    System.out.println(export);
                    break;
            }


            data = scanner.nextLine().split("\\s+");
        }
        if (data[1].equals("Normal")) {
            Collections.sort(contacts);
        } else {
            Collections.reverse(contacts);
        }
        System.out.print("Contacts: ");
        for (String contact : contacts) {
            System.out.print(contact + " ");

        }
    }
}
