module gri.todolist.todolist {
    requires javafx.controls;
    requires javafx.fxml;


    opens gri.todolist to javafx.fxml;
    exports gri.todolist;
}