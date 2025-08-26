package joobot.command;
import joobot.task.TaskList;
import joobot.main.Ui;
import joobot.main.Storage;

import joobot.main.JooException;

public abstract class Command {
    protected boolean isExit = false;

    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws JooException;

    public boolean isExit() {
        return isExit;
    }
}
