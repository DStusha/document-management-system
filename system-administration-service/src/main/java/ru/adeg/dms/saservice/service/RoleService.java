package ru.adeg.dms.saservice.service;

import ru.adeg.dms.saservice.entity.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    Role addRole(Role role);
    void delete(long id);
    List<Role> getAll();
    Optional<Role> getRoleByName(String name);
    Optional<Role> getRoleById(Long id);
}
