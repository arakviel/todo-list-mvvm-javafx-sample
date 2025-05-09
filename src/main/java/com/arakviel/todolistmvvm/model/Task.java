package com.arakviel.todolistmvvm.model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Task {

    private final StringProperty name = new SimpleStringProperty();
    private final BooleanProperty completed = new SimpleBooleanProperty();

    public Task(String name) {
        this.name.set(name);
        this.completed.set(false);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public boolean isCompleted() {
        return completed.get();
    }

    public BooleanProperty completedProperty() {
        return completed;
    }
}
