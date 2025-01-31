package com.matheus.java_task.adapters.input;

import com.matheus.java_task.domain.model.Task;
import com.matheus.java_task.ports.TaskManagerPort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class ManagerController {

    //coloquei dentro da camada de input para que seja nossa porta de entrada de dados
    private final TaskManagerPort taskManagerPort;

    public ManagerController(TaskManagerPort taskManagerPort) {
        this.taskManagerPort = taskManagerPort;
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskManagerPort.createTask(task);
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskManagerPort.getAllTasks();
    }

    @GetMapping("/{id}")
    public Optional<Task> getTaskById(@PathVariable Long id) {
        return taskManagerPort.getTaskById(id);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task task) {
        return taskManagerPort.updateTask(id, task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskManagerPort.deleteTask(id);
    }
}
