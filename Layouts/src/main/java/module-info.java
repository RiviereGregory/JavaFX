module gri.layouts {
    requires javafx.controls;
    requires javafx.fxml;


    opens gri.layouts to javafx.fxml;
    exports gri.layouts;
}