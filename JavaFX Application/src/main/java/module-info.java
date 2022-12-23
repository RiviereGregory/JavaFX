module gri.javafxapplication {
    requires javafx.controls;
    requires javafx.fxml;


    opens gri.javafxapplication to javafx.fxml;
    exports gri.javafxapplication;
}