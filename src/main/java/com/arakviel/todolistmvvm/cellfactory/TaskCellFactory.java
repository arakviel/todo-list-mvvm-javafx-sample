package com.arakviel.todolistmvvm.cellfactory;

import atlantafx.base.theme.Styles;
import com.arakviel.todolistmvvm.model.Task;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.util.Callback;
import org.kordamp.ikonli.javafx.FontIcon;

public class TaskCellFactory implements Callback<ListView<Task>, ListCell<Task>> {

    @Override
    public ListCell<Task> call(ListView<Task> taskListView) {
        return new ListCell<>() {
            private final CheckBox checkBox = new CheckBox();
            private final Button removeButton = new Button("", new FontIcon("bx-trash"));
            private final HBox itemHBox = new HBox(checkBox, removeButton);
            private Task currentTask; // трекінг поточного Task

            {
                HBox.setHgrow(checkBox, Priority.ALWAYS);
                checkBox.setMaxWidth(Double.MAX_VALUE);
                removeButton.getStyleClass().addAll(Styles.BUTTON_OUTLINED, Styles.FLAT, Styles.DANGER, Styles.SMALL);
                removeButton.setMnemonicParsing(true);
            }

            @Override
            protected void updateItem(Task task, boolean empty) {
                super.updateItem(task, empty);

                if (currentTask != null) {
                    checkBox.selectedProperty().unbindBidirectional(currentTask.completedProperty());
                }

                if (empty || task == null) {
                    currentTask = null;
                    setGraphic(null);
                    setText(null);
                } else {
                    currentTask = task;
                    checkBox.setText(task.getName());
                    checkBox.selectedProperty().bindBidirectional(task.completedProperty());

                    removeButton.setOnAction(event -> taskListView.getItems().remove(task));
                    setGraphic(itemHBox);
                }
            }
        };
    }

}
