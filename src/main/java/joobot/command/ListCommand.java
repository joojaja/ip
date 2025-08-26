package joobot.command;
import joobot.task.TaskList;
import joobot.main.Ui;
import joobot.main.Storage;
import joobot.main.JooException;

public class ListCommand extends Command {
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws JooException {
        if (tasks.size() == 0) throw new JooException(JooException.ErrorType.EMPTY_LIST);
        ui.showList(tasks.getAllTasks());
    }
}
