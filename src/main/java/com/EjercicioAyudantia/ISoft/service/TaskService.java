package com.EjercicioAyudantia.ISoft.service;
import com.EjercicioAyudantia.ISoft.model.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class TaskService {
    private List<Task> tasks = new ArrayList<>();
    private Long nextId = 1L;

    public Task createTask(Task task) {
        task.setId(nextId++);
        task.setCompletada(false);
        tasks.add(task);
        return task;
    }

    public List<Task> getAllTasks() {
        return tasks;
    }

    public Optional<Task> findById(Long id) {
        return tasks.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst();
    }

    public List<Task> filterTasks(String prioridad, String titulo, String fechaLimite) {
    return tasks.stream()
            .filter(task -> prioridad == null || task.getPrioridad().equalsIgnoreCase(prioridad))
            .filter(task -> titulo == null || task.getTitulo().toLowerCase().contains(titulo.toLowerCase()))
            .filter(task -> fechaLimite == null || Objects.equals(task.getFechaLimite(), fechaLimite))
            .toList();
    }

}

