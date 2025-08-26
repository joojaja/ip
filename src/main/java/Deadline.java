public class Deadline extends Task {
    private final String by_date;

    public Deadline(String description, String by_date) {
        super(description);
        this.by_date = by_date;
    }

    @Override
    public String getTypeIcon() {
        return "[D]";
    }

    @Override
    public String toString() {
        return getTypeIcon() + super.toString()
                + " (by: " + by_date + ")";
    }

    @Override
    public String toFileString() {
        return "D | " + (isDone() ? "1" : "0") + " | " + getDescription() + " | " + by_date;
    }
}
