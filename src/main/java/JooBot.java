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
            int index;
            Task task;

            switch (start_word) {
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
                    index = Integer.parseInt(text[1]) - 1;
                    tasks.get(index).markDone();
                    System.out.println(
                                "    ____________________________________________________________\n" +
                                "    Nice! I've marked this task as done:\n" +
                                "      " + tasks.get(index) + "\n" +
                                "    ____________________________________________________________");
                    break;

                // change status to unmark
                case "unmark":
                    index = Integer.parseInt(text[1]) - 1;
                    tasks.get(index).markNotDone();
                    System.out.println(
                                    "    ____________________________________________________________\n" +
                                    "    OK, I've marked this task as not done yet:\n" +
                                    "      " + tasks.get(index) + "\n" +
                                    "    ____________________________________________________________");
                    break;

                // to do task
                case "todo": {
                    task = new ToDo(text[1]);
                    tasks.add(task);
                    printNewTask(task, tasks.size());
                    break;
                }

                // deadline task
                case "deadline": {
                    String[] deadlineParts = text[1].split("/by", 2);
                    String desc = deadlineParts[0].trim();
                    String by = deadlineParts.length > 1 ? deadlineParts[1].trim() : "";
                    task = new Deadline(desc, by);
                    tasks.add(task);
                    printNewTask(task, tasks.size());
                    break;
                }

                // event task
                case "event": {
                    String[] eventParts = text[1].split("/from", 2);
                    String desc = eventParts[0].trim();

                    String[] timeParts = eventParts[1].split("/to", 2);
                    String from = timeParts[0].trim();
                    String to = timeParts.length > 1 ? timeParts[1].trim() : "";
                    task = new Event(desc, from, to);
                    tasks.add(task);
                    printNewTask(task, tasks.size());
                    break;
                }

                // error
                default:
                    System.out.println("Error");
            }
        }
    }

    public static void printNewTask(Task task, int count) {
        System.out.println(
                "    ____________________________________________________________\n" +
                        "     Got it. I've added this task:\n" +
                        "       " + task + "\n" +
                        "     Now you have " + count + " tasks in the list.\n" +
                        "    ____________________________________________________________");
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
