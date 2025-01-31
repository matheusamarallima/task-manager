package com.matheus.java_task.service;

import com.matheus.java_task.adapters.persist.TaskRepository;
import com.matheus.java_task.domain.model.Task;
import com.matheus.java_task.domain.model.enums.TaskStatusEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;
import java.util.Optional;

public class TaskManagerImplTest {

    private TaskRepository taskRepository;
    private TaskManagerImpl taskManager;

    @BeforeEach
    void setUp() {
        taskRepository = mock(TaskRepository.class);
        taskManager = new TaskManagerImpl(taskRepository);
    }

    @Test
    void createTaskTest() {
        LocalDateTime now = LocalDateTime.now();
        Task task = new Task(1L, "dormir", "dormir", TaskStatusEnum.COMPLETED, now);
        when(taskRepository.save(any(Task.class))).thenReturn(task);

        Task createdTask = taskManager.createTask(task);

        assertNotNull(createdTask);
        assertEquals("dormir", createdTask.getTitle());
        assertEquals(TaskStatusEnum.COMPLETED, createdTask.getStatus());
        verify(taskRepository, times(1)).save(any(Task.class));
    }

    @Test
    void getTaskByIdTest() {
        LocalDateTime now = LocalDateTime.now();
        Task task = new Task(1L, "dormir", "dormir", TaskStatusEnum.COMPLETED, now);
        when(taskRepository.findById(1L)).thenReturn(Optional.of(task));

        Optional<Task> foundTask = taskManager.getTaskById(1L);

        assertTrue(foundTask.isPresent());
        assertEquals("dormir", foundTask.get().getTitle());
        verify(taskRepository, times(1)).findById(1L);
    }

    @Test
    void updateTaskTest() {
        LocalDateTime now = LocalDateTime.now();
        Task existingTask = new Task(1L, "dormir", "dormir", TaskStatusEnum.COMPLETED, now);
        when(taskRepository.existsById(1L)).thenReturn(true);
        when(taskRepository.save(any(Task.class))).thenReturn(existingTask);

        Task updatedTask = taskManager.updateTask(1L, existingTask);

        assertNotNull(updatedTask);
        assertEquals("dormir", updatedTask.getTitle());
        verify(taskRepository, times(1)).save(any(Task.class));
    }

    @Test
    void notFoundUpdateTest() {
        LocalDateTime now = LocalDateTime.now();
        Task existingTask = new Task(1L, "dormir", "dormir", TaskStatusEnum.COMPLETED, now);
        when(taskRepository.existsById(1L)).thenReturn(false);

        assertThrows(RuntimeException.class, () -> taskManager.updateTask(1L, existingTask));
    }

    @Test
    void deleteTaskTest() {
        LocalDateTime now = LocalDateTime.now();
        Task existingTask = new Task(1L, "dormir", "dormir", TaskStatusEnum.COMPLETED, now);
        when(taskRepository.existsById(1L)).thenReturn(true);

        taskManager.deleteTask(1L);

        verify(taskRepository, times(1)).deleteById(1L);
    }
}
