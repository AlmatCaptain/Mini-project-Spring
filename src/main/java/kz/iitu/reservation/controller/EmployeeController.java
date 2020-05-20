package kz.iitu.reservation.controller;

import kz.iitu.reservation.model.Employee;
import kz.iitu.reservation.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getListEmployee() {
        return employeeService.getListEmployee();
    }


    @PostMapping("/registration")
    public void addEmployee(@RequestBody Employee e) {
        employeeService.addEmployee(e);
    }

    @PutMapping("/admin/update/{id}")
    public void updateMember(@PathVariable Long id, @RequestBody Employee employee) {
        employee.setId(id);
        employeeService.updateEmployee(id, employee);
    }

    @PatchMapping("/admin/update/{id}")
    public void updateUserName(@PathVariable Long id, @RequestParam String name) {
        employeeService.updateName(id, name);
    }

    @PatchMapping("/admin/role/{id}")
    public void updateUserRole(@PathVariable Long id, @RequestParam String role) {
        employeeService.updateRole(id, role);
    }

    @DeleteMapping("/admin/delete/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }

    @PostMapping("/admin/add")
    public void createEmployee(@RequestBody Employee e) {
        employeeService.addEmployee(e);
    }


}
