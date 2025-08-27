package joobot.main;

import joobot.task.TaskList;
import joobot.command.Command;

import java.util.Scanner; // for input

/**
 * The main class for running the JooBot application.
 * <p>
 * JooBot is a simple task chatbot that supports commands such as
 * adding tasks, marking them as done, deleting them, and persisting them
 * to a file.
 */
public class JooBot {
    private final Storage storage;
    private final TaskList tasks;
    private final Ui ui;

    /**
     * Creates a JooBot instance with the given file path for storage.
     *
     * @param filePath the file path where tasks are stored
     */
    public JooBot(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        tasks = new TaskList(storage.load());
    }

    /**
     * Runs the chatbot, reading user input until an exit command is given.
     * <p>
     * The method parses user input into {@link Command} objects,
     * executes them, and handles any errors during execution.
     */
    public void run() {
        ui.showWelcome();
        boolean isExit = false;
        Scanner scanner = new Scanner(System.in);

        while (!isExit) {
            try {
                String fullCommand = scanner.nextLine();
                Command command = Parser.parse(fullCommand);
                command.execute(tasks, ui, storage);
                isExit = command.isExit();
            } catch (JooException e) {
                ui.showError(e.getMessage());
            }
        }
    }

    /**
     * The entry point of the JooBot application.
     *
     * @param args command-line arguments (unused)
     */
    public static void main(String[] args) {
        new JooBot("data/joobot.txt").run();
    }
}
