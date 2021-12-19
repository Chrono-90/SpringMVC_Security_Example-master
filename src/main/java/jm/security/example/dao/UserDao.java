package jm.security.example.dao;

import jm.security.example.model.User;

import java.util.List;

public interface UserDao {
    User getUserByName(String name);

    void createOrUpdateUser(User user);

    void removeUser(Long id);

    User findUserById(Long id);

    List<User> getAllUsers();
}