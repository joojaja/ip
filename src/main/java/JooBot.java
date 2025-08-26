import java.util.Scanner; // for input

public class JooBot {
    private final Storage storage;
    private final TaskList tasks;
    private final Ui ui;

    public JooBot(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        tasks = new TaskList(storage.load());
    }

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

    public static void main(String[] args) {
        new JooBot("data/joobot.txt").run();
    }
}
