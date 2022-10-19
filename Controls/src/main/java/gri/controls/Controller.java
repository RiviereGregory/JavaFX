package gri.controls;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private TextField namedField;

    @FXML
    public void onButtonClick() {
        System.out.println("Hello, " + namedField.getText());
    }
}