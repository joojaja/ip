package joobot.main;
import java.util.ArrayList;

import joobot.task.Task;


/**
 * Handles all user interface output for JooBot.
 * Responsible for displaying messages, task updates, and errors to the user.
 */
public class Ui {

    /**
     * Displays the welcome message when the bot starts.
     */
    public void showWelcome() {
        System.out.println(
                "    ____________________________________________________________\n"
                       + "    Hello! I'm JooBot\n"
                       + "    What can I do for you?\n"
                + "    ____________________________________________________________\n"
        );
    }

    /**
     * Displays a generic message inside a box format.
     *
     * @param message the message to display
     */
    public void showMessage(String message) {
        System.out.println(
                        "    ____________________________________________________________\n"
                        + "     " + message + "\n"
                        + "    ____________________________________________________________"
        );
    }

    /**
     * Displays the goodbye message when the bot exits.
     */
    public void showGoodbye() {
        System.out.println(
                "    ____________________________________________________________\n"
                        + "    Bye. Hope to see you again soon!\n"
                + "    ____________________________________________________________\n"
        );
    }

    /**
     * Displays confirmation that a task was added.
     *
     * @param task  the task that was added
     * @param count current number of tasks in the list
     */
    public void showTaskAdded(Task task, int count) {
        System.out.println(
                "    ____________________________________________________________\n"
                        + "     Got it. I've added this task:\n"
                        + "       " + task + "\n"
                        + "     Now you have " + count + " tasks in the list.\n"
                        + "    ____________________________________________________________");
    }

    /**
     * Displays confirmation that a task was deleted.
     *
     * @param task  the task that was deleted
     * @param count current number of tasks remaining in the list
     */
    public void showTaskDeleted(Task task, int count) {
        System.out.println(
                "    ____________________________________________________________\n"
                        + "     Noted. I've removed this task:\n"
                        + "       " + task + "\n"
                        + "     Now you have " + count + " tasks in the list.\n"
                        + "    ____________________________________________________________");
    }

    /**
     * Displays confirmation that a task was marked as done.
     *
     * @param task the task marked as done
     */
    public void showTaskMarked(Task task) {
        System.out.println(
                "    ____________________________________________________________\n"
                        + "    Nice! I've marked this task as done:\n"
                        + "      " + task + "\n"
                        + "    ____________________________________________________________");
    }

    /**
     * Displays confirmation that a task was unmarked (set as not done).
     *
     * @param task the task unmarked
     */
    public void showTaskUnmarked(Task task) {
        System.out.println(
                "    ____________________________________________________________\n"
                        + "    OK, I've marked this task as not done yet:\n"
                        + "      " + task + "\n"
                        + "    ____________________________________________________________");
    }

    /**
     * Displays the list of all tasks.
     *
     * @param tasks the list of tasks to display
     */
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

    /**
     * Displays an error message.
     *
     * @param message the error message to display
     */
    public void showError(String message) {
        System.out.println(message);
    }
}
