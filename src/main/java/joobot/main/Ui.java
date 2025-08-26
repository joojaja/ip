package joobot.main;
import joobot.task.Task;
import java.util.ArrayList;

public class Ui {
    public void showWelcome() {
        System.out.println(
                "    ____________________________________________________________\n" +
                        "    Hello! I'm JooBot\n" +
                        "    What can I do for you?\n" +
                "    ____________________________________________________________\n"
        );
    }

    public void showGoodbye() {
        System.out.println(
                "    ____________________________________________________________\n" +
                        "    Bye. Hope to see you again soon!\n" +
                "    ____________________________________________________________\n"
        );
    }

    public void showTaskAdded(Task task, int count) {
        System.out.println(
                "    ____________________________________________________________\n" +
                        "     Got it. I've added this task:\n" +
                        "       " + task + "\n" +
                        "     Now you have " + count + " tasks in the list.\n" +
                        "    ____________________________________________________________");
    }

    public void showTaskDeleted(Task task, int count) {
        System.out.println(
                "    ____________________________________________________________\n" +
                        "     Noted. I've removed this task:\n" +
                        "       " + task + "\n" +
                        "     Now you have " + count + " tasks in the list.\n" +
                        "    ____________________________________________________________");
    }

    public void showTaskMarked(Task task) {
        System.out.println(
                "    ____________________________________________________________\n" +
                        "    Nice! I've marked this task as done:\n" +
                        "      " + task + "\n" +
                        "    ____________________________________________________________");
    }

    public void showTaskUnmarked(Task task) {
        System.out.println(
                "    ____________________________________________________________\n" +
                        "    OK, I've marked this task as not done yet:\n" +
                        "      " + task + "\n" +
                        "    ____________________________________________________________");
    }

    public void showList(ArrayList<Task> tasks) {
        StringBuilder sb = new StringBuilder();
        sb.append("    ____________________________________________________________\n");
        sb.append("     Here are the tasks in your list:\n");
        for (int i = 0; i < tasks.size(); i++) {
            sb.append("     ").append(i + 1).append(". ").append(tasks.get(i)).append("\n");
        }
        sb.append("    ____________________________________________________________\n");
        System.out.println(sb);
    }

    public void showError(String message) {
        System.out.println(message);
    }
}
