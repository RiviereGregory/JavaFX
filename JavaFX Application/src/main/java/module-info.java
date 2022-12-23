module gri.javafxapplication {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;


    opens gri.javafxapplication to javafx.fxml;
    exports gri.javafxapplication;
}