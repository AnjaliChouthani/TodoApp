package com.example.ToDoList.Repository;

import com.example.ToDoList.entity.Task;
import com.example.ToDoList.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface TaskRepo extends JpaRepository<Task,Long> {

}
