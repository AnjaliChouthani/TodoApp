package com.example.ToDoList.Services;

import com.example.ToDoList.Repository.TaskRepo;
import com.example.ToDoList.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class TaskServices {
    @Autowired
    TaskRepo taskRepo;


    public Task addTask(Task task) {
        return taskRepo.save(task);
    }

    public Optional<Task> getTask(Long id) {
        return taskRepo.findById(id);
    }

    public ResponseEntity<String> deleteTask(Long id) {
       Optional<Task> task= taskRepo.findById(id);
       if(task.isPresent()){
            Task data=task.get();
            if(data.isCompleted()){
                taskRepo.deleteById(id);
                return ResponseEntity.ok("successfully completed ");
            }
            else{
                return ResponseEntity.badRequest().body(" Task is not completed ");
            }
       }
       else{
           return new ResponseEntity(HttpStatus.NOT_FOUND);
       }
    }

    public ResponseEntity<String> updateTask(Long id) {

       Optional<Task>task=taskRepo.findById(id);
       if(task.isPresent()){
           Task data=task.get();
           if(!data.isCompleted()) {
               data.setCompleted(true);
               taskRepo.save(data);
              return ResponseEntity.ok("Task is completed");
           }
           else{

             return ResponseEntity.badRequest().body("Task is already completed ");
           }
       }
       else{
        return ResponseEntity.badRequest().body("Task Not found");
       }

    }
}





