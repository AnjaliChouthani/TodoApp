package com.example.ToDoList.Controller;

import com.example.ToDoList.Services.TaskServices;
import com.example.ToDoList.entity.Task;
import com.example.ToDoList.entity.User;
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
    @DeleteMapping("/delete/{name}/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable String name,@PathVariable Long id){
       return taskServices.deleteTask(name,id);
    }


    @PutMapping("/update/{name}/{id}")
    public ResponseEntity<String> updateTask(@PathVariable String name,@PathVariable Long id){
        return taskServices.updateTask(name,id);
    }
}