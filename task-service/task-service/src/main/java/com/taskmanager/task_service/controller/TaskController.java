package com.taskmanager.task_service.controller;

import com.taskmanager.task_service.dto.TaskRequest;
import com.taskmanager.task_service.dto.TaskResponse;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final AtomicLong counter = new AtomicLong(1);
    private final Map<Long, TaskResponse> tasks = new ConcurrentHashMap<>();

    @PostMapping
    public TaskResponse createTask(@RequestBody TaskRequest request) {
        Long id = counter.getAndIncrement();
        TaskResponse task = new TaskResponse(
                id,
                request.getTitle(),
                request.isCompleted(),
                request.getUserId()
        );
        tasks.put(id, task);
        return task;
    }

    @PutMapping("/{id}")
    public TaskResponse updateTask(@PathVariable Long id, @RequestBody TaskRequest request) {
        TaskResponse updated = new TaskResponse(
                id,
                request.getTitle(),
                request.isCompleted(),
                request.getUserId()
        );
        tasks.put(id, updated);
        return updated;
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable Long id) {
        tasks.remove(id);
        return "Task deleted";
    }

    @GetMapping
    public List<TaskResponse> getTasksByUser(@RequestParam Long userId) {
    return tasks.values()
            .stream()
            .filter(task -> userId.equals(task.getUserId()))
            .collect(Collectors.toList());
        }
}

