import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Deadline extends Task {
    private LocalDateTime by_date;
    private final String raw; // string

    public Deadline(String description, String by) {
        super(description);
        this.raw = by;

        // try parsing
        try {
            DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("d/M/yyyy HHmm");
            this.by_date = LocalDateTime.parse(by, inputFormat);
        } catch (DateTimeParseException e) {
            this.by_date = null; // not a valid date
        }
    }

    @Override
    public String getTypeIcon() {
        return "[D]";
    }

    @Override
    public String toString() {
        if (by_date != null) {
            DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("dd MMM yyyy HHmm");
            return getTypeIcon() + super.toString() + " (by: " + by_date.format(outputFormat) + ")";
        } else {
            return getTypeIcon() + super.toString() + " (by: " + raw + ")";
        }
    }

    @Override
    public String toFileString() {
        if (by_date != null) {
            DateTimeFormatter fileFormat = DateTimeFormatter.ofPattern("d/M/yyyy HHmm");
            return "D | " + (isDone() ? "1" : "0") + " | " + getDescription() + " | " + by_date.format(fileFormat);
        } else {
            return "D | " + (isDone() ? "1" : "0") + " | " + getDescription() + " | " + raw;
        }
    }
}
