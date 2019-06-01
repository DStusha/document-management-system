package ru.adeg.dms.saservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.adeg.dms.saservice.entity.Role;
import ru.adeg.dms.saservice.service.RoleService;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping
    public ResponseEntity<List<Role>> allRoles() {
        List<Role> roles = roleService.getAll();
        return ResponseEntity.ok().body(roles);
    }

    @GetMapping(value = "/{roleId}")
    public ResponseEntity<Role> getRole(@PathVariable("roleId") Long roleId)
            throws EntityNotFoundException {
        Optional<Role> Role = roleService.getRoleById(roleId);
        if (!Role.isPresent())
            throw new EntityNotFoundException("id-" + roleId);
        return ResponseEntity.ok().body(Role.get());
    }

    @PostMapping
    public ResponseEntity<Role> createRole(@RequestBody @Valid Role Role) {
        Role p = roleService.addRole(Role);
        return ResponseEntity.status(201).body(p);
    }
    @PutMapping(value = "/{roleId}")
    public ResponseEntity<Role> updateRole(@RequestBody @Valid Role Role,
                                           @PathVariable("roleId") Long roleId) throws EntityNotFoundException {
        Optional<Role> p = roleService.getRoleById(roleId);
        if (!p.isPresent())
            throw new EntityNotFoundException("id-" + roleId);
        return ResponseEntity.ok().body(roleService.addRole(Role));
    }
    @DeleteMapping(value = "/{roleId}")
    public ResponseEntity<Role> deleteRole(@PathVariable("roleId") Long roleId)
            throws EntityNotFoundException {
        Optional<Role> p = roleService.getRoleById(roleId);
        if (!p.isPresent())
            throw new EntityNotFoundException("id-" + roleId);
        roleService.delete(roleId);
        return ResponseEntity.ok().body(p.get());
    }

}

