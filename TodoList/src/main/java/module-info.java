module gri.todolist.todolist {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;


    opens gri.todolist to javafx.fxml;
    exports gri.todolist;
}