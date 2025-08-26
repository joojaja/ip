package joobot.command;
import joobot.task.TaskList;
import joobot.task.Task;
import joobot.main.Ui;
import joobot.main.Storage;

public class AddCommand extends Command {
    private final Task task;

    public AddCommand(Task task) {
        this.task = task;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        tasks.addTask(task);
        storage.save(tasks.getAllTasks());
        ui.showTaskAdded(task, tasks.size());
    }
}
