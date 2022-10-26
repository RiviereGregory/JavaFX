package gri.controls;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller {
    private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    @FXML
    private TextField namedField;
    @FXML
    private Button clickMeButton;
    @FXML
    private Button byeButton;
    @FXML
    private CheckBox ourCheckBox;
    @FXML
    private Label ourLabel;

    @FXML
    public void initialize() {
        clickMeButton.setDisable(true);
        byeButton.setDisable(true);
    }

    @FXML
    public void onButtonClick(ActionEvent actionEvent) {
        if (actionEvent.getSource().equals(clickMeButton)) {
            LOGGER.log(Level.INFO, "Hello, {0}", namedField.getText());
        } else if (actionEvent.getSource().equals(byeButton)) {
            LOGGER.log(Level.INFO, "Bye, {0}", namedField.getText());
        }

        Runnable task = () -> {
            try {
                String goingString = Platform.isFxApplicationThread() ? "UI Thread" : "Background Thread";
                LOGGER.log(Level.WARNING, "I am going to sleep on the: {}", goingString);
                Thread.sleep(10000);
                // Permet de mettre à jour le thread principal sans planter le thread
                Platform.runLater(() -> {
                    String updatingString = Platform.isFxApplicationThread() ? "UI Thread" : "Background Thread";
                    LOGGER.log(Level.WARNING, "I am updating the label on the:  {}", updatingString);
                    ourLabel.setText("We did something!");
                });
            } catch (InterruptedException interruptedException) {
                // we don't care about this
                Thread.currentThread().interrupt();
            }
        };

        new Thread(task).start();


        if (ourCheckBox.isSelected()) {
            namedField.clear();
            initialize();
        }
    }

    @FXML
    public void handleKeyReleased() {
        String text = namedField.getText();
        boolean disableButtons = text.isEmpty() || text.trim().isEmpty();
        clickMeButton.setDisable(disableButtons);
        byeButton.setDisable(disableButtons);
    }

    @FXML
    public void handleChange() {
        LOGGER.log(Level.INFO, "The checkbox is {0}", (ourCheckBox.isSelected() ? "checked" : "not checked"));
    }
}