import java.util.*;


public class dictionary {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> dictionary = new TreeMap<>();
        String[] input = scanner.nextLine().split("\\s+\\|\\s+");

        for (String wordAndDef : input) {

            String[] definitions = wordAndDef.split("\\s*:\\s*");
            dictionary.putIfAbsent(definitions[0], new ArrayList<>());

            for (int i = 1; i < definitions.length; i++) {
                dictionary.get(definitions[0]).add(definitions[i]);
            }
        }
        String[] print = scanner.nextLine().split("\\s*\\|\\s*");

        for (String printWordDef : print) {
            if (dictionary.containsKey(printWordDef)) {
                System.out.println(printWordDef);
                dictionary.get(printWordDef).stream().sorted(((e1, e2) ->
                        Integer.compare(e2.length(), e1.length())))
                        .forEach(e -> System.out.println(String.format("-%s", e)));
            }
        }
        String output = scanner.nextLine();
        if ("List".equals(output)) {
            dictionary.forEach((key, value) -> System.out.print(String.format("%s ", key)));

        }

    }
}
