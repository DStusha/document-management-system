package ru.adeg.dms.uservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.adeg.dms.uservice.entity.User;
import ru.adeg.dms.uservice.service.UserService;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Secured("ROLE_ANONYMOUS")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam(value = "login") final String login,
                                @RequestParam(value = "password") final String password) {
        return userService.login(login, password);
    }

    @Secured("ROLE_ANONYMOUS")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public User add(@RequestBody final User user) {
        return userService.addUser(user);
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> get(@PathVariable final Long id) throws EntityNotFoundException {
        Optional<User> user = userService.getUserById(id);
        if (!user.isPresent())
            throw new EntityNotFoundException("id-" + id);
        return ResponseEntity.ok().body(user.get());
    }
}
