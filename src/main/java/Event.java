import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Event extends Task {
    private LocalDateTime from;
    private LocalDateTime to;
    private String fromRaw;
    private String toRaw;

    public Event(String description, String from, String to) {
        super(description);
        this.fromRaw = from;
        this.toRaw = to;

        // try parsing from and to
        DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("d/M/yyyy HHmm");
        try {
            this.from = LocalDateTime.parse(from, inputFormat);
        } catch (DateTimeParseException e) {
            this.from = null;
        }

        try {
            this.to = LocalDateTime.parse(to, inputFormat);
        } catch (DateTimeParseException e) {
            this.to = null;
        }
    }

    @Override
    public String getTypeIcon() {
        return "[E]";
    }

    @Override
    public String toString() {
        DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("dd MMM yyyy HHmm");

        String fromString = (from != null)
                ? from.format(outputFormat)
                : fromRaw;
        String toString = (to != null)
                ? to.format(outputFormat)
                : toRaw;

        return getTypeIcon() + super.toString()
                + " (from: " + fromString + " to: " + toString + ")";
    }

    @Override
    public String toFileString() {
        DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("dd MMM yyyy HHmm");

        String fromString = (from != null)
                ? from.format(outputFormat)
                : fromRaw;
        String toString = (to != null)
                ? to.format(outputFormat)
                : toRaw;

        return "E | " + (isDone() ? "1" : "0") + " | " + getDescription() + " | " + fromString + " | " + toString;
    }
}
