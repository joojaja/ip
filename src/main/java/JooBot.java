import java.util.Objects;
import java.util.Scanner; // for input
import java.util.ArrayList; // for keeping track of list

public class JooBot {
    public static void main(String[] args) {
        String start =
                """
                    ____________________________________________________________
                    Hello! I'm JooBot
                    What can I do for you?
                    ____________________________________________________________
                """;
        System.out.println(start); // starting greeting message
        ArrayList<Task> tasks = new ArrayList<>(); // create a dynamic list of strings
        Scanner scanner = new Scanner(System.in); // used to get input

        while (true) {
            String all_input = scanner.nextLine();
            String[] text = all_input.split(" ", 2);
            String start_word = text[0];

            String input = start_word.equals("mark") || start_word.equals("unmark")
                           ? start_word
                           : all_input;

            int index = start_word.equals("mark") || start_word.equals("unmark")
                        ? Integer.parseInt(text[1]) - 1
                        : 0;

            switch (input) {
                // end program
                case "bye":
                    System.out.println(  "    ____________________________________________________________\n"
                            + "    Bye. Hope to see you again soon!\n"
                            + "    ____________________________________________________________");
                    scanner.close();
                    return;

                // list all tasks
                case "list":
                    listAllItem(tasks);
                    break;

                // change status to mark
                case "mark":
                    tasks.get(index).markDone();
                    System.out.println(
                                "    ____________________________________________________________\n" +
                                "    Nice! I've marked this task as done:\n" +
                                "      " + tasks.get(index) + "\n" +
                                "    ____________________________________________________________");
                    break;

                // change status to unmark
                case "unmark":
                    tasks.get(index).markNotDone();
                    System.out.println(
                                    "    ____________________________________________________________\n" +
                                    "    OK, I've marked this task as not done yet:\n" +
                                    "      " + tasks.get(index) + "\n" +
                                    "    ____________________________________________________________");
                    break;

                // add new task
                default:
                    addTask(input, tasks);
            }
        }
    }

    public static void addTask(String description, ArrayList<Task> list) {
        Task task = new Task(description);
        list.add(task);
        System.out.printf(
                        """
                            ____________________________________________________________
                            added: %s
                            ____________________________________________________________\n
                        """, task
                        );
    }

    public static void listAllItem(ArrayList<Task> list) {
        String items = "";
        for (int i = 0; i < list.size(); i++) {
            items += String.format("     %d. %s\n", i + 1, list.get(i));
        }
        items =   "    ____________________________________________________________\n"
                + "     Here are the tasks in your list:\n"
                + items
                + "    ____________________________________________________________\n";
        System.out.println(items);
    }
}
