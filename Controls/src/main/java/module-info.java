module gri.controls {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;


    opens gri.controls to javafx.fxml;
    exports gri.controls;
}