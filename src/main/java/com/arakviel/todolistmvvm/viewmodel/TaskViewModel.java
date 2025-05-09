package com.arakviel.todolistmvvm.viewmodel;

import com.arakviel.todolistmvvm.model.Task;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TaskViewModel {
    private final ObservableList<Task> tasks = FXCollections.observableArrayList();
    private final StringProperty newTaskName = new SimpleStringProperty();

    public ObservableList<Task> getTasks() {
        return tasks;
    }

    public StringProperty newTaskNameProperty() {
        return newTaskName;
    }

    public void addTask() {
        if(!newTaskName.get().trim().isEmpty()) {
            tasks.add(new Task(newTaskName.get()));
            newTaskName.set("");
        }
    }

    public void removeTask(Task task) {
        tasks.remove(task);
    }
}
