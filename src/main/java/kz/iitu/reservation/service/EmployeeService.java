package kz.iitu.reservation.service;

import kz.iitu.reservation.model.Employee;
import kz.iitu.reservation.repository.EmployeeRepository;
import kz.iitu.reservation.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeService implements UserDetailsService {

    private final EmployeeRepository employeeRepository;
    private final RolesRepository rolesRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, RolesRepository rolesRepository) {
        this.employeeRepository = employeeRepository;
        this.rolesRepository = rolesRepository;
    }

    public List<Employee> getListEmployee() {
        return employeeRepository.findAll();
    }

    public void addEmployee(Employee e) {
        e.setRoles(Collections.singletonList(rolesRepository.getOne(2L)));
        e.setPassword(passwordEncoder.encode(e.getPassword()));
        employeeRepository.saveAndFlush(e);
    }

    public void updateEmployee(Long id, Employee employee) {
        Employee e = employeeRepository.findById(id)
                                       .orElse(null);

        if (e != null) {
            e.setUsername(employee.getUsername());
            e.setPassword(employee.getPassword());

            employeeRepository.saveAndFlush(e);
        }
    }

    public void updateName(Long id, String name) {
        Employee employee = employeeRepository.findById(id)
                                              .get();
        employee.setUsername(name);
        employeeRepository.saveAndFlush(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public void updateRole(Long id, String role) {
        Employee employee = employeeRepository.findById(id)
                                              .get();

        Employee e = new Employee();
        e.setId(employee.getId());
        e.setUsername(employee.getUsername());
        e.setPassword(employee.getPassword());
        e.setReservedRooms(employee.getReservedRooms());

        if (role.equals("ADMIN"))
            e.setRoles(Collections.singletonList(rolesRepository.getOne(2L)));
        else if (role.equals("USER")) {
            e.setRoles(Collections.singletonList(rolesRepository.getOne(1L)));
        }

        employeeRepository.save(e);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Employee employee = employeeRepository.findByUsername(s);

        if (employee == null) {
            throw new UsernameNotFoundException("Member: " + s + " not found!");
        }
        return employee;
    }
}
