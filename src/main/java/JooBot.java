import java.util.Scanner;

public class JooBot {
    public static void main(String[] args) {
        String text =
                """
                    ____________________________________________________________
                    Hello! I'm JooBot
                    What can I do for you?
                    ____________________________________________________________
                
                """;
        System.out.println(text);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String command = scanner.nextLine();
            System.out.println("    -------------------------------");
            if (command.equals("bye")) {
                System.out.println("    Bye. Hope to see you again soon!\n");
                scanner.close();
                return;
            }
            System.out.println("\t" + command);
            System.out.println("    -------------------------------");
        }

    }
}
