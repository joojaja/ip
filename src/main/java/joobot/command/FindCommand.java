package joobot.command;
import java.util.List;

import joobot.main.Storage;
import joobot.main.Ui;
import joobot.task.Task;
import joobot.task.TaskList;



/**
 * Represents a command that searches for tasks
 * whose descriptions contain the given keyword.
 */
public class FindCommand extends Command {
    private final String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        List<Task> matches = tasks.findTasks(this.keyword);

        if (matches.isEmpty()) {
            ui.showMessage("No matching tasks found for keyword: " + keyword);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Here are the matching tasks in your list:\n");
            for (int i = 0; i < matches.size(); i++) {
                sb.append("    ").append(i + 1).append(".").append(matches.get(i).toString()).append("\n");
            }
            sb.deleteCharAt(sb.length() - 1); // remove the last newline
            ui.showMessage(sb.toString());
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
