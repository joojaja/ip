package joobot.task;

import joobot.main.DateTimeValue;

public class Deadline extends Task {
    private DateTimeValue by;

    public Deadline(String description, String by) {
        super(description);
        this.by = new DateTimeValue(by);
    }

    @Override
    public String getTypeIcon() {
        return "[D]";
    }

    @Override
    public String toString() {
        return getTypeIcon() + super.toString()
                + " (by: " + by.toDisplayString() + ")";
    }

    @Override
    public String toFileString() {
        return "D | " + (isDone() ? "1" : "0")
                + " | " + getDescription()
                + " | " + by.toFileString();
    }
}
