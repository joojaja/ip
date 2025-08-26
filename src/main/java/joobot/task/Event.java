package joobot.task;

import joobot.main.DateTimeValue;

public class Event extends Task {
    private DateTimeValue from;
    private DateTimeValue to;

    public Event(String description, String from, String to) {
        super(description);
        this.from = new DateTimeValue(from);
        this.to = new DateTimeValue(to);
    }

    @Override
    public String getTypeIcon() {
        return "[E]";
    }

    @Override
    public String toString() {
        return getTypeIcon() + super.toString()
                + " (from: " + from.toDisplayString()
                + " to: " + to.toDisplayString() + ")";
    }

    @Override
    public String toFileString() {
        return "E | " + (isDone() ? "1" : "0")
                + " | " + getDescription()
                + " | " + from.toFileString()
                + " | " + to.toFileString();
    }
}
