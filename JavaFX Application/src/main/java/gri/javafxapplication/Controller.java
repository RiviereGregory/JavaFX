package gri.javafxapplication;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.List;
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
        FileChooser chooser = new FileChooser();
        // gridPane.getScene().getWindow() permet de ne pas ouvrir plusieur explorateur
//        chooser.showOpenDialog(gridPane.getScene().getWindow());

        // limitation des choix de la boite de dialogue
        chooser.setTitle("Save Application File");
        chooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text", "*.txt"),
                new FileChooser.ExtensionFilter("PDF", "*.pdf"),
                new FileChooser.ExtensionFilter("Images Files", "*.jpg", "*.png", "*.gif"),
                new FileChooser.ExtensionFilter("All Files", "*.*")
        );

        //Pour choisir un repertoire
//        DirectoryChooser chooser = new DirectoryChooser();
        // gridPane.getScene().getWindow() permet de ne pas ouvrir plusieur explorateur
        //Pour ouvrir une boite de dialogue
//        File file = chooser.showDialog(gridPane.getScene().getWindow());

        // Pour enregistrer un fichier
        //File file = chooser.showSaveDialog(gridPane.getScene().getWindow());
        // Pour ouvrir plusieurs fichiers
        List<File> files = chooser.showOpenMultipleDialog(gridPane.getScene().getWindow());
        if (files != null) {
            for (File file : files) {
                LOGGER.log(Level.INFO, "Chemin du repertoire: {0}", file.getPath());
            }
        } else {
            LOGGER.log(Level.INFO, "Chooser cancel");
        }
    }
}