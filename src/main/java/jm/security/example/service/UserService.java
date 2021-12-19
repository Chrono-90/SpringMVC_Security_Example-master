package jm.security.example.service;

import jm.security.example.model.User;

import java.util.List;

public interface UserService {

    void removeUser(Long id);

    List<User> getAllUsers();

    User getUserByName(String name);

    void createOrUpdateUser(User user);

    User fiendUserById(Long id);


}
