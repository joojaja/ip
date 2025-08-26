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
