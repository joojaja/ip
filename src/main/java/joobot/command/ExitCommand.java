package joobot.command;
import joobot.task.TaskList;
import joobot.main.Ui;
import joobot.main.Storage;

public class ExitCommand extends Command {
    public ExitCommand() {
        this.isExit = true;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showGoodbye();
    }
}
