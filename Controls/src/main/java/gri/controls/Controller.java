package gri.controls;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private TextField namedField;
    @FXML
    private Button clickMeButton;
    @FXML
    private Button byeButton;

    @FXML
    public void initialize() {
        clickMeButton.setDisable(true);
        byeButton.setDisable(true);
    }

    @FXML
    public void onButtonClick(ActionEvent actionEvent) {
        if (actionEvent.getSource().equals(clickMeButton)) {
            System.out.println("Hello, " + namedField.getText());
        } else if (actionEvent.getSource().equals(byeButton)) {
            System.out.println("Bye, " + namedField.getText());
        }
    }

    @FXML
    public void handleKeyReleased() {
        String text = namedField.getText();
        boolean disableButtons = text.isEmpty() || text.trim().isEmpty();
        clickMeButton.setDisable(disableButtons);
        byeButton.setDisable(disableButtons);
    }
}