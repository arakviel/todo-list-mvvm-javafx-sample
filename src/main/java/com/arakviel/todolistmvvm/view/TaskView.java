package com.arakviel.todolistmvvm.view;

import atlantafx.base.theme.Tweaks;
import com.arakviel.todolistmvvm.cellfactory.TaskCellFactory;
import com.arakviel.todolistmvvm.model.Task;
import com.arakviel.todolistmvvm.viewmodel.TaskViewModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class TaskView implements Initializable {
    @FXML
    private TextField taskField;
    @FXML
    private ListView<Task> taskList;
    private TaskViewModel viewModel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        viewModel = new TaskViewModel();
        taskField.textProperty().bindBidirectional(viewModel.newTaskNameProperty());
        taskList.setItems(viewModel.getTasks());
        taskList.setCellFactory(new TaskCellFactory());
        taskList.setMinHeight(150);
        taskList.setMaxWidth(300);
        taskList.getStyleClass().add(Tweaks.EDGE_TO_EDGE);
    }

    @FXML
    private void addTask() {
        viewModel.addTask();
    }

    @FXML
    private void removeTask() {
        Task selectedTask = taskList.getSelectionModel().getSelectedItem();
        if (selectedTask != null) viewModel.removeTask(selectedTask);
    }
}
