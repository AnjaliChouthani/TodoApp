package com.example.ToDoList.Services;

import com.example.ToDoList.Repository.TaskRepo;
import com.example.ToDoList.Repository.UserRepository;
import com.example.ToDoList.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskServices {
    @Autowired
   private TaskRepo taskRepo;
    @Autowired
   private UserRepository userRepo;


    public Task addTask(Task task) {
        return taskRepo.save(task);
    }

    public Optional<Task> getTask(Long id) {

        return taskRepo.findById(id);
    }

    public ResponseEntity<String> deleteTask(String name,Long id) {
        if (!userRepo.existsByName(name)) {
            return new ResponseEntity<>("user not found ", HttpStatus.NOT_FOUND);
        }
        Optional<Task> task = taskRepo.findById(id);
        if (task.isPresent()) {
            Task data = task.get();
            if (data.isCompleted()) {
                taskRepo.deleteById(id);
                return ResponseEntity.ok("deletion successfully completed ");
            } else {
                return ResponseEntity.badRequest().body(" Task is not completed ");
            }
        }
        return new ResponseEntity<>("Task Not Found",HttpStatus.NOT_FOUND);
    }


    public ResponseEntity<String> updateTask(String name, Long id) {
        if(!userRepo.existsByName(name)){
            return new ResponseEntity<>("Not Found User"+name,HttpStatus.NOT_FOUND);
        }
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
      return new ResponseEntity<>("Task Not Found ",HttpStatus.NOT_FOUND);

    }


}





