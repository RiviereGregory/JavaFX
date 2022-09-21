module gri.controls {
    requires javafx.controls;
    requires javafx.fxml;


    opens gri.controls to javafx.fxml;
    exports gri.controls;
}