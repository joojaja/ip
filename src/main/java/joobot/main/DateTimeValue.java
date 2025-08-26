package joobot.main;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateTimeValue {
    private final String raw;
    private final LocalDateTime dateTime;

    private static final DateTimeFormatter FORMAT =
            DateTimeFormatter.ofPattern("d/M/yyyy HHmm");
    private static final DateTimeFormatter DISPLAY_FORMAT =
            DateTimeFormatter.ofPattern("dd MMM yyyy HHmm");

    public DateTimeValue(String input) {
        this.raw = input;
        LocalDateTime parsed = null;
        try {
            parsed = LocalDateTime.parse(input, FORMAT);
        } catch (DateTimeParseException e) {
            // not a date, leave null
        }
        this.dateTime = parsed;
    }

    public String toDisplayString() {
        return (dateTime != null) ? dateTime.format(DISPLAY_FORMAT) : raw;
    }

    public String toFileString() {
        return (dateTime != null) ? dateTime.format(FORMAT) : raw;
    }
}
