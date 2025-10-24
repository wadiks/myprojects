package com.example;

import com.example.dao.UsersDao;
import com.example.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
@RestController
@RequestMapping("/user")
public class HealthService {

    private final UsersDao userDao;

    public HealthService(UsersDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/health")
    public String health() {
        return "{\"status\": \"OK\"}";
    }

    @PostMapping("/add")
    public User addUsers(@RequestBody User user) {

        return userDao.save(user);
    }

    @GetMapping("/get_all")
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    @GetMapping("/get/{id}")
    public Optional<User> getUsers(@PathVariable("id") String id) {
        return userDao.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") String id) {
        userDao.deleteById(id);
        return "ID " + id + " Delete";
    }

    @PutMapping("/edit")
    public User editUsers( @RequestBody User user) {
    return userDao.save(user);
    }

    public static void main(String[] args) {
        SpringApplication.run(HealthService.class, args);
    }
}