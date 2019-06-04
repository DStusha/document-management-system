package ru.adeg.dms.authservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.adeg.dms.models.Role;
import ru.adeg.dms.security.TokenUser;
import ru.adeg.dms.authservice.entity.User;
import ru.adeg.dms.authservice.entity.UserRole;
import ru.adeg.dms.authservice.repository.UserRepository;
import ru.adeg.dms.authservice.service.TokenService;
import ru.adeg.dms.authservice.service.UserService;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private BCryptPasswordEncoder bcryptEncoder;
    @Value("${path.saservice}")
    private String saservicePath;
    private final String getRolesPath = saservicePath + "roles";

    public String login(final String login, final String password){
        Optional<User> user = repository.findByLogin(login);
        if (user.isPresent() && bcryptEncoder.matches(password, user.get().getPassword())) {
            TokenUser tokenUser = new TokenUser(user.get().getLogin(), getRoleNames(user.get().getRoles()));
            return tokenService.getToken(tokenUser);
        }
        throw new RuntimeException("Error");
    }

    private List<String> getRoleNames(Set<UserRole> roles){
        Iterator<UserRole> i = roles.iterator();
        List<String> roleNames = new ArrayList<String>();
        while(i.hasNext()){
            roleNames.add(getRoleName(i.next().getRole_id()));
        }
        return roleNames;
    }

    private String getRoleName(Long id){
        RestTemplate rest = new RestTemplate(Collections.singletonList(new MappingJackson2HttpMessageConverter()));
        return rest.getForObject(getRolesPath + id.toString(), Role.class).getName();
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
