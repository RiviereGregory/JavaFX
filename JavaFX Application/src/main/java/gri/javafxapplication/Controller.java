package gri.javafxapplication;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.stage.DirectoryChooser;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller {
    private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    @FXML
    private Label label;

    @FXML
    private Button button4;

    @FXML
    private GridPane gridPane;

    public void initialize() {
        button4.setEffect(new DropShadow());
    }

    @FXML
    public void handleMouseEnter() {
        label.setScaleX(2.0);
        label.setScaleY(2.0);
    }

    @FXML
    public void handleMouseExit() {
        label.setScaleX(1.0);
        label.setScaleY(1.0);
    }

    public void handleClick() {
        //Pour choisir un fichier
//        FileChooser chooser = new FileChooser();
//        // gridPane.getScene().getWindow() permet de ne pas ouvrir plusieur explorateur
//        chooser.showOpenDialog(gridPane.getScene().getWindow());

        //Pour choisir un repertoire
        DirectoryChooser chooser = new DirectoryChooser();
        // gridPane.getScene().getWindow() permet de ne pas ouvrir plusieur explorateur
        File file = chooser.showDialog(gridPane.getScene().getWindow());
        if (file != null) {
            LOGGER.log(Level.INFO, "Chemin du repertoire: {0}", file.getPath());
        } else {
            LOGGER.log(Level.INFO, "Chooser cancel");
        }
    }
}