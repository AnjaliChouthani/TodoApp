package com.example.ToDoList.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   private String name;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Task> getTaskList() {
        return taskList;
    }
    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

@JsonManagedReference
    @OneToMany(mappedBy ="user",cascade = CascadeType.ALL)
   private List<Task>taskList;

//    public User() {
//
//    }
//
//    public User(Long id, String name, List<Task> taskList) {
//        this.id = id;
//        this.name = name;
//        this.taskList = taskList;
//    }
}
