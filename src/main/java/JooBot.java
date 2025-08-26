import java.util.Scanner; // for input
import java.util.ArrayList; // for keeping track of list

public class JooBot {
    public static void main(String[] args) throws JooException {

        Storage storage = new Storage("data/duke.txt");
        ArrayList<Task> tasks = storage.load();

        String start =
                """
                    ____________________________________________________________
                    Hello! I'm JooBot
                    What can I do for you?
                    ____________________________________________________________
                """;
        System.out.println(start); // starting greeting message
        Scanner scanner = new Scanner(System.in); // used to get input

        while (true) {
            try {
                String all_input = scanner.nextLine().trim(); // remove empty spaces, will help error for next line if only spaces are the input

                // error check for empty input or only-space-input
                if (all_input.isEmpty()) {
                    throw new JooException(JooException.ErrorType.EMPTY_INPUT);
                }

                String[] text = all_input.split(" ", 2); // text = [first_word, rest_of_the_input]
                String first_word = text[0];
                int index;
                Task task;

                switch (first_word) {
                    // end program
                    case "bye":
                        System.out.println("""
                                    ____________________________________________________________
                                    Bye. Hope to see you again soon!
                                    ____________________________________________________________
                                """);
                        scanner.close();
                        return;

                    // list all tasks
                    case "list":

                        if (tasks.isEmpty()) { // empty to-do list
                            throw new JooException(JooException.ErrorType.EMPTY_LIST);
                        }

                        listAllItem(tasks);
                        break;

                    // change status to mark
                    case "mark":
                        if (text.length < 2) throw new JooException(JooException.ErrorType.NO_INDEX);
                        index = Integer.parseInt(text[1]) - 1;
                        if (index < 0 || index >= tasks.size()) throw new JooException(JooException.ErrorType.OUT_OF_INDEX);
                        tasks.get(index).markDone();
                        storage.save(tasks);
                        System.out.println(
                                "    ____________________________________________________________\n" +
                                        "    Nice! I've marked this task as done:\n" +
                                        "      " + tasks.get(index) + "\n" +
                                        "    ____________________________________________________________");
                        break;

                    // change status to unmark
                    case "unmark":
                        if (text.length < 2) throw new JooException(JooException.ErrorType.NO_INDEX);
                        index = Integer.parseInt(text[1]) - 1;
                        if (index < 0 || index >= tasks.size()) throw new JooException(JooException.ErrorType.OUT_OF_INDEX);
                        tasks.get(index).markNotDone();
                        storage.save(tasks);
                        System.out.println(
                                "    ____________________________________________________________\n" +
                                        "    OK, I've marked this task as not done yet:\n" +
                                        "      " + tasks.get(index) + "\n" +
                                        "    ____________________________________________________________");
                        break;

                    // to do task
                    case "todo": {
                        if (text.length < 2 || text[1].trim().isEmpty()) {
                            throw new JooException(JooException.ErrorType.MISSING_DESC);
                        }
                        task = new ToDo(text[1]);
                        tasks.add(task);
                        storage.save(tasks);
                        printNewTask(task, tasks.size());
                        break;
                    }

                    // deadline task
                    case "deadline": {
                        if (text.length < 2 || text[1].trim().isEmpty()) {
                            throw new JooException(JooException.ErrorType.MISSING_DESC);
                        }
                        String[] deadlineParts = text[1].split("/by", 2);

                        if (deadlineParts[0].trim().isEmpty()) {
                            throw new JooException(JooException.ErrorType.MISSING_DESC);
                        }
                        String desc = deadlineParts[0].trim();
                        String by = deadlineParts.length > 1 ? deadlineParts[1].trim() : "";

                        if (by.isEmpty()) throw new JooException(JooException.ErrorType.MISSING_BY_DATE);

                        task = new Deadline(desc, by);
                        tasks.add(task);
                        storage.save(tasks);
                        printNewTask(task, tasks.size());
                        break;
                    }

                    // event task
                    case "event": {
                        if (text.length < 2 || text[1].trim().isEmpty()) {
                            throw new JooException(JooException.ErrorType.MISSING_DESC);
                        }

                        String[] eventParts = text[1].split("/from", 2);

                        if (eventParts.length < 2) {
                            throw new JooException(JooException.ErrorType.MISSING_FROM_TO);
                        }

                        String desc = eventParts[0].trim();

                        String[] timeParts = eventParts[1].split("/to", 2);

                        if (timeParts.length < 2) {
                            throw new JooException(JooException.ErrorType.MISSING_FROM_TO);
                        }

                        String from = timeParts[0].trim();
                        String to = timeParts[1].trim();

                        task = new Event(desc, from, to);
                        tasks.add(task);
                        storage.save(tasks);
                        printNewTask(task, tasks.size());
                        break;
                    }

                    // delete a task
                    case "delete":
                        if (text.length < 2) throw new JooException(JooException.ErrorType.NO_INDEX);
                        index = Integer.parseInt(text[1]) - 1;
                        if (index < 0 || index >= tasks.size()) throw new JooException(JooException.ErrorType.OUT_OF_INDEX);

                        task = tasks.remove(index); // remove the task
                        System.out.println(
                                "    ____________________________________________________________\n" +
                                        "     Noted. I've removed this task:\n" +
                                        "       " + task + "\n" +
                                        "     Now you have " + tasks.size() + " tasks in the list.\n" +
                                        "    ____________________________________________________________");
                        storage.save(tasks);
                        break;

                    // error
                    default:
                        throw new JooException(JooException.ErrorType.DEFAULT);
                }
            } catch (JooException e) {
                System.out.println(e.getMessage());
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
