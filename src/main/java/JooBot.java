import java.util.Scanner; // for input
import java.util.ArrayList; // for keeping track of list

public class JooBot {
    public static void main(String[] args) {
        String text =
                """
                    ____________________________________________________________
                    Hello! I'm JooBot
                    What can I do for you?
                    ____________________________________________________________
                """;
        System.out.println(text); // starting greeting message

        // create a dynamic list of strings
        ArrayList<String> items = new ArrayList<>();

        // used to get input
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("bye")) {
                System.out.println(  "    ____________________________________________________________\n"
                                   + "    Bye. Hope to see you again soon!\n"
                                   + "    ____________________________________________________________");
                scanner.close();
                return;
            } else if (input.equals("list")) {
                listAllItem(items);
            } else {
                addItem(input, items);
            }
        }
    }

    public static void addItem(String item, ArrayList<String> list) {
        list.add(item);
        System.out.printf(
                        """
                            ____________________________________________________________
                            added: %s
                            ____________________________________________________________\n
                        """, item
                        );
    }

    public static void listAllItem(ArrayList<String> list) {
        String items = "";
        for (int i = 0; i < list.size(); i++) {
            items += String.format("    %d. %s\n", i + 1, list.get(i));
        }
        items =   "    ____________________________________________________________\n"
                + items
                + "    ____________________________________________________________\n";
        System.out.println(items);
    }
}
