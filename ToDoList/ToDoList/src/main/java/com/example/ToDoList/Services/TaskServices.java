package com.example.ToDoList.Services;

import com.example.ToDoList.Repository.TaskRepo;
import com.example.ToDoList.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class TaskServices {
    @Autowired
    TaskRepo taskRepo;


    public void addTask(Task task) {
        taskRepo.save(task);
    }

    public Task getTask(Long id) {
        return (Task) taskRepo.findById(id).orElse(null);
    }

    public void deleteTask(Long id) {
          taskRepo.deleteById(id);
    }
}
