public class JooException extends Exception {
    public enum ErrorType {
        EMPTY_INPUT,
        EMPTY_LIST,
        NO_INDEX,
        OUT_OF_INDEX,
        MISSING_DESC,
        MISSING_BY_DATE,
        MISSING_FROM_TO,
        DEFAULT
    }

    private final ErrorType type;

    public JooException(ErrorType type) {
        super(getErrorMessage(type));
        this.type = type;
    }

    public ErrorType getType() {
        return type;
    }

    private static String getErrorMessage(ErrorType type) {
        return switch (type) {
            case EMPTY_INPUT ->
                    """
                        Error! Empty input is not allowed.
                        Type one of these as inputs:
                         - todo
                         - deadline
                         - event
                         - list
                         - bye
                    """;

            case EMPTY_LIST ->
                    """
                        You have an empty to do list!
                    """;

            case NO_INDEX, OUT_OF_INDEX ->
                    """
                        Please enter an index that is of valid range.
                    """;

            case MISSING_DESC ->
                    """
                        Please enter a description of a todo task.
                    """;

            case MISSING_BY_DATE ->
                    """
                        The deadline must have a /by <text>.
                    """;

            case MISSING_FROM_TO ->
                    """
                        The deadline must have a /from <text> /to <text>.
                    """;

            case DEFAULT ->
                    """
                        Please enter a valid command.
                        Type one of these as inputs:
                         - todo
                         - deadline
                         - event
                         - list
                         - bye
                    """;

            default -> "This is a different error.";
        };
    }
}
