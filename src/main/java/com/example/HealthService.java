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
public class HealthService {

    private final UsersDao userDao;

    public HealthService(UsersDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/health")
    public String health() {
        return "{\"status\": \"OK\"}";
    }

    @PostMapping("/user/add")
    public User addUsers(@RequestBody User user) {

        return userDao.save(user);

    }

    @GetMapping("/user/get_all")
    public List<User> getAllUsers() {
        System.out.println("user = getall");
        return userDao.findAll();
    }

    @GetMapping("/user/get/{id}")
    public Optional<User> getUsers(@PathVariable("id") String id) {
        return userDao.findById(id);
    }

    @DeleteMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") String id) {
        userDao.deleteById(id);
        return "ID " + id + " Delete";
    }

    @PutMapping("/user/edit")
    public User editUsers( @RequestBody User user) {
    return userDao.save(user);
    }

    public static void main(String[] args) {
        SpringApplication.run(HealthService.class, args);
    }
}