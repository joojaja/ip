package joobot.command;
import joobot.task.TaskList;
import joobot.task.Task;
import joobot.main.Ui;
import joobot.main.Storage;
import joobot.main.JooException;

public class UnmarkCommand extends Command {
    private final int index;

    public UnmarkCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws JooException {
        Task t = tasks.getTask(index);
        t.markNotDone();
        storage.save(tasks.getAllTasks());
        ui.showTaskUnmarked(t);
    }
}
