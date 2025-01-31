package com.matheus.java_task.ports;

import com.matheus.java_task.domain.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskManagerPort {
    //aqui estão os nossos constratos
    Task createTask(Task task);
    List<Task> getAllTasks();
    Optional<Task> getTaskById(Long id);
    Task updateTask(Long id, Task task);
    void deleteTask(Long id);
}
