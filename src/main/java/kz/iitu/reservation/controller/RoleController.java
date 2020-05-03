package kz.iitu.reservation.controller;

import kz.iitu.reservation.model.Role;
import kz.iitu.reservation.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {

    private final RolesRepository rolesRepository;

    @Autowired
    public RoleController(RolesRepository rolesRepository) {
        this.rolesRepository = rolesRepository;
    }

    @GetMapping
    public List<Role> getAllRoles() {
        return rolesRepository.findAll();
    }
}
