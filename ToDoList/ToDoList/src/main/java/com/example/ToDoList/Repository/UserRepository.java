package com.example.ToDoList.Repository;

import com.example.ToDoList.entity.User;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {


    boolean existsByName(String name);

    Optional<User> findByName(String name);
}
