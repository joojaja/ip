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
        return getTypeIcon() + getStatusIcon() + " " + getDescription() + " (by: " + by_date + ")";
    }
}
