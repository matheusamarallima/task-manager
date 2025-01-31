package com.matheus.java_task.service;

import com.matheus.java_task.adapters.persist.TaskRepository;
import com.matheus.java_task.domain.model.Task;
import com.matheus.java_task.ports.TaskManagerPort;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskManagerImpl implements TaskManagerPort {


    //Essa classe contem a implementação do nosso serviço
    private final TaskRepository taskRepository;

    public TaskManagerImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public Task updateTask(Long id, Task task) {
        if (taskRepository.existsById(id)) {
            task.setId(id);
            return taskRepository.save(task);
        }
        throw new RuntimeException("Task not found");
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
