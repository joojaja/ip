package joobot.command;
import joobot.main.JooException;
import joobot.main.Storage;
import joobot.main.Ui;
import joobot.task.Task;
import joobot.task.TaskList;

/**
 * Represents a command that marks a task
 */
public class MarkCommand extends Command {
    private final int index;

    public MarkCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws JooException {
        Task t = tasks.getTask(index);
        t.markDone();
        storage.save(tasks.getAllTasks());
        ui.showTaskMarked(t);
    }
}
