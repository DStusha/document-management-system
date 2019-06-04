package ru.adeg.dms.saservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.adeg.dms.saservice.entity.Role;
import ru.adeg.dms.saservice.repository.RoleRepository;
import ru.adeg.dms.saservice.service.RoleService;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role addRole(Role role) {
        return roleRepository.saveAndFlush(role);
    }

    public void delete(long id) {
        roleRepository.deleteById(id);
    }

    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    public Optional<Role> getRoleEntityById(Long id) {
        return roleRepository.findById(id);
    }

    public ru.adeg.dms.models.Role getRoleById(Long id) {
        Optional<Role> role = roleRepository.findById(id);
        if (role.isPresent())
        {
            return new ru.adeg.dms.models.Role(role.get().getId(), role.get().getName());
        }
        return null;
    }
}
