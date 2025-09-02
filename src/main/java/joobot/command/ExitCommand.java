package joobot.command;
import joobot.main.Storage;
import joobot.main.Ui;
import joobot.task.TaskList;

/**
 * Represents a command that exits the program
 */
public class ExitCommand extends Command {
    public ExitCommand() {
        this.isExit = true;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showGoodbye();
    }
}
