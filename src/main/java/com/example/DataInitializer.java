package com.example;

import com.example.dao.UsersDao;
import com.example.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initData(UsersDao userDao) {
        return args -> {
            // Проверяем, есть ли уже пользователи в базе
            if (userDao.count() == 0) {
                System.out.println("Инициализация тестовых данных...");

                List<User> initialUsers = Arrays.asList(
                        new User(null, "Иван", "Иванов", "ivanov@example.com", "+79161234567"),
                        new User(null, "Петр", "Петров", "petrov@example.com", "+79169876543"),
                        new User(null, "Мария", "Сидорова", "sidorova@example.com", "+79165544333")
                );

                userDao.saveAll(initialUsers);
                System.out.println("Добавлено " + initialUsers.size() + " тестовых пользователей");
            } else {
                System.out.println("В базе уже есть пользователи, инициализация не требуется");
            }
        };
    }
}