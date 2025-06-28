package com.example.ToDoList.Services;

import com.example.ToDoList.Repository.TaskRepo;
import com.example.ToDoList.Repository.UserRepository;
import com.example.ToDoList.entity.Task;
import com.example.ToDoList.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
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


    public ResponseEntity<String> updateTask(String name, Long id) {
        Optional<User>useropt=userRepo.findByName(name);
        if(useropt.isEmpty()){
            return new ResponseEntity<>("user does not exist ",HttpStatus.NOT_FOUND);
        }
        User userdetails=useropt.get();  //exist user
        if(!taskRepo.existsById(id)){            //task exist or not if not error
            return new ResponseEntity<>("task does not exist ",HttpStatus.NOT_FOUND);
        }
        Optional<Task>task=taskRepo.findById(id);
         Task taskdetails=task.get();//get task details
        if(!taskdetails.getUser().getId().equals(userdetails.getId())){
            return new ResponseEntity<>("user does not contain this taskid "+id,HttpStatus.NOT_FOUND);
         }
        if(taskdetails.isCompleted()){
            return ResponseEntity.ok("Already updated this task ");
        }
        taskdetails.setCompleted(true);
        taskRepo.save(taskdetails);
        return ResponseEntity.ok("succesfully updated task ");
    }

    public ResponseEntity<String> deleteTask(String name, Long id) {

        Optional<User>useropt=userRepo.findByName(name);
          if(useropt.isEmpty()){
              return new ResponseEntity<>("user does not exist ",HttpStatus.NOT_FOUND);
          }
          User userdetails=useropt.get(); //user details
          //check task exist or not
        if(!taskRepo.existsById(id)){
            return new ResponseEntity<>("task does not exist ",HttpStatus.NOT_FOUND);
        }
        Task taskdetails=taskRepo.findById(id).get();
        if(!taskdetails.getUser().getId().equals(userdetails.getId())){
            return new ResponseEntity<>("user does not contain this  task ",HttpStatus.NOT_FOUND);
        }
        if(!taskdetails.isCompleted()){
            return new  ResponseEntity<>("task does not completed ",HttpStatus.BAD_REQUEST);
        }
        taskRepo.deleteById(id);
          return ResponseEntity.ok("successfully deleted task ");
    }
}








