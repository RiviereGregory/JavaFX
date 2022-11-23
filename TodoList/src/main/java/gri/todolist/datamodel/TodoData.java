package gri.todolist.datamodel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TodoData {
    private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private static TodoData instance = new TodoData();
    private static String filename = "TodoListItems.txt";


    private ObservableList<TodoItem> todoItems;
    private DateTimeFormatter formatter;

    private TodoData() {
        formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    }

    public static TodoData getInstance() {
        return instance;
    }

    public ObservableList<TodoItem> getTodoItems() {
        return todoItems;
    }

    public void addTodoItem(TodoItem todoItem) {
        todoItems.add(todoItem);
    }

    public void loadTodoItems() throws IOException {
        todoItems = FXCollections.observableArrayList();
        Path path = Paths.get(filename);
        BufferedReader bufferedReader = Files.newBufferedReader(path);

        String input;
        try {
            while ((input = bufferedReader.readLine()) != null) {
                String[] itemPieces = input.split(";");
                if (itemPieces.length != 3) {
                    LOGGER.log(Level.SEVERE, "split > 3");
                    continue;
                }
                String shortDescription = itemPieces[0];
                String details = itemPieces[1];
                String dateString = itemPieces[2];

                try {
                    LocalDate date = LocalDate.parse(dateString, formatter);
                    TodoItem todoItem = new TodoItem(shortDescription, details, date);
                    todoItems.add(todoItem);
                } catch (DateTimeParseException dateTimeParseException) {
                    LOGGER.log(Level.SEVERE, "Ce n est pas une date", dateTimeParseException);
                }
            }
        } finally {
            bufferedReader.close();
        }
    }

    public void storeTodoitems() throws IOException {
        Path path = Paths.get(filename);
        BufferedWriter bufferedWriter = Files.newBufferedWriter(path);
        try {
            Iterator<TodoItem> iterator = todoItems.iterator();
            while (iterator.hasNext()) {
                TodoItem item = iterator.next();
                bufferedWriter.write(String.format("%s;%s;%s",
                        item.getShortDescription(),
                        item.getDetails(),
                        item.getDeadline().format(formatter)));
                bufferedWriter.newLine();
            }

        } finally {
            bufferedWriter.close();
        }
    }

    public void deleteTodoItem(TodoItem item) {
        todoItems.remove(item);
    }
}
