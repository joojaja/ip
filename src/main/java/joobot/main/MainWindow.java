package joobot.main;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * Controller for the main GUI.
 */
public class MainWindow extends AnchorPane {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    private JooBot joobot;

    private Image userImage = new Image(this.getClass().getResourceAsStream("/images/DaUser.png"));
    private Image botImage = new Image(this.getClass().getResourceAsStream("/images/DaJoo.png"));

    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
    }

    /** Injects the JooBot instance. */
    public void setJooBot(JooBot b) {
        joobot = b;

        // Add intro message from JooBot at startup
        String intro = "Hi Traveller!\nHow can I assist you today?";
        dialogContainer.getChildren().add(
                DialogBox.getBotDialog(intro, botImage)
        );
    }

    /**
     * Creates two dialog boxes, one echoing user input and the other containing JooBot's reply,
     * then appends them to the dialog container. Clears the user input after processing.
     */
    @FXML
    private void handleUserInput() {
        String input = userInput.getText();
        String response = joobot.getResponse(input);
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(input, userImage),
                DialogBox.getBotDialog(response, botImage)
        );
        userInput.clear();
    }
}
