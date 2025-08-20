public class JooException extends Exception {
    public JooException(String type) {
        super(getErrorMessage(type));
    }

    private static String getErrorMessage(String type) {
        return switch (type) {
            case "empty_input" ->
                    """
                        Error! Empty input is not allowed.
                        Type one of these as inputs:
                         - todo
                         - deadline
                         - event
                         - list
                         - bye
                    """;

            case "empty_list" ->
                    """
                        You have an empty to do list!
                    """;

            case "no_index", "out_of_index" ->
                    """
                        Please enter an index that is of valid range.
                    """;

            case "missing_desc" ->
                    """
                        Please enter a description of a todo task.
                    """;

            case "missing_by_date" ->
                    """
                        The deadline must have a /by <text>.
                    """;

            case "missing_from_to" ->
                    """
                        The deadline must have a /from <text> /to <text>.
                    """;

            case "default" ->
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
