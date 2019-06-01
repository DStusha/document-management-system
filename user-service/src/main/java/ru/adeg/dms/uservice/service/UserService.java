package ru.adeg.dms.uservice.service;

import ru.adeg.dms.uservice.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    String login(final String login, final String password);
    User addUser(User user);
    void delete(long id);
    List<User> getAll();
    Optional<User> getUserByLogin(String login);
    Optional<User> getUserById(Long id);
}
