import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class questt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String>journal= Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        String input=scanner.nextLine();

        while (!"Retire!".equals(input)){
            String []data=input.split(" - ");
            String command=data[0];

            switch (command){
                case "Start":
                    if (!journal.contains(data[1])){
                        journal.add(data[1]);
                    }
                    break;

                case "Complete":
                    if (journal.contains(data[1])){
                        journal.remove(data[1]);
                    }
                    break;

                case "Side Quest":
                    String[] words=data[1].split(":");
                    String quest=words[0];
                    String sideQuest=words[1];

                    if (journal.contains(quest)&&!journal.contains(sideQuest)){
                        int index=journal.indexOf(quest);
                        journal.add(index+1,sideQuest);
                    }


                    break;

                case "Renew":
                    if (journal.contains(data[1])){
                        journal.remove(data[1]);
                        journal.add(data[1]);
                    }
                    break;
            }


            input=scanner.nextLine();
        }

        for (int i = 0; i <journal.size() ; i++) {
            if (i==journal.size()-1){
                System.out.print(journal.get(i));
            }else {
                System.out.print(journal.get(i)+", ");
            }

        }
    }
}

