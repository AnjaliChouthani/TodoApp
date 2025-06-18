package com.example.ToDoList.Controller;

import com.example.ToDoList.Services.TaskServices;
import com.example.ToDoList.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    TaskServices taskServices;

    @PostMapping
    public Task addTask(@RequestBody Task task) {
        return taskServices.addTask(task);
    }

    @GetMapping("/id")
    public Optional<Task> getTask(@RequestParam Long id) {
        return taskServices.getTask(id);
    }
    @DeleteMapping("/id")
    public ResponseEntity<String> deleteTask(@RequestParam Long id){
       return taskServices.deleteTask(id);
    }


    @PutMapping("/id")
    public ResponseEntity<String> updateTask(@RequestParam Long id){
        return taskServices.updateTask(id);
    }
}