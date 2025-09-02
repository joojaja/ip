package joobot.command;
import joobot.main.JooException;
import joobot.main.Storage;
import joobot.main.Ui;
import joobot.task.TaskList;

/**
 * Represents a abstract class for command
 */
public abstract class Command {
    protected boolean isExit = false;

    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws JooException;

    public boolean isExit() {
        return isExit;
    }
}
