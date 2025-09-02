package joobot.command;
import joobot.main.JooException;
import joobot.main.Storage;
import joobot.main.Ui;
import joobot.task.Task;
import joobot.task.TaskList;

/**
 * Represents a command that deletes a task
 */
public class DeleteCommand extends Command {
    private final int index;

    public DeleteCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws JooException {
        if (index < 0 || index >= tasks.size()) {
            throw new JooException(JooException.ErrorType.OUT_OF_INDEX);
        }
        Task removed = tasks.deleteTask(index);
        storage.save(tasks.getAllTasks());
        ui.showTaskDeleted(removed, tasks.size());
    }
}
