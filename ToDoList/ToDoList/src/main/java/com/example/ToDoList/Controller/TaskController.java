package com.example.ToDoList.Controller;

import com.example.ToDoList.Services.TaskServices;
import com.example.ToDoList.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    TaskServices taskServices;

    @PostMapping
       public void addTask(@RequestBody Task task){
           taskServices.addTask(task);
       }
       @GetMapping("/id")
    public Task getTask(@RequestParam Long id){
        return taskServices.getTask(id);
       }
     @DeleteMapping("/id")
       public void deleteTask(@RequestParam Long id){
        taskServices.deleteTask(id);
       }

}
