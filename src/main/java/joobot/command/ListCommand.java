package joobot.command;
import joobot.main.JooException;
import joobot.main.Storage;
import joobot.main.Ui;
import joobot.task.TaskList;

/**
 * Represents a command that lists all tasks
 */
public class ListCommand extends Command {
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws JooException {
        if (tasks.size() == 0) {
            throw new JooException(JooException.ErrorType.EMPTY_LIST);
        }
        ui.showList(tasks.getAllTasks());
    }
}
