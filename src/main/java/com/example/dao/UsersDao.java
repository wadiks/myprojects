package com.example.dao;

import com.example.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
import java.util.Optional;

public interface UsersDao extends MongoRepository<User, String> {

    List<User> findAll();

    Optional<User> findById(String id);

    User save(User entity);

    void deleteById(String id);
}
