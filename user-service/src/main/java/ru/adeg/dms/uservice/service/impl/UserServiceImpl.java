package ru.adeg.dms.uservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.adeg.dms.uservice.entity.User;
import ru.adeg.dms.uservice.repository.UserRepository;
import ru.adeg.dms.uservice.service.TokenService;
import ru.adeg.dms.uservice.service.UserService;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private BCryptPasswordEncoder bcryptEncoder;

    public String login(final String login, final String password) {
        User user = repository.findByLogin(login).get();
        if (user != null && bcryptEncoder.matches(password, user.getPassword())) {
            return tokenService.getToken(user);
        }
        throw new RuntimeException("Error");
    }

    private String encodePassword(final String password) {
        return bcryptEncoder.encode(password);
    }

    public User addUser(User user) {
        return repository.saveAndFlush(user);
    }

    public void delete(long id) {
        repository.deleteById(id);
    }

    public List<User> getAll() {
        return repository.findAll();
    }

    public Optional<User> getUserByLogin(String login) {
        return repository.findByLogin(login);
    }

    public Optional<User> getUserById(Long id) {
        return repository.findById(id);
    }
}
