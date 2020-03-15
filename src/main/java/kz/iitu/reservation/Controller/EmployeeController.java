package kz.iitu.reservation.Controller;

import kz.iitu.reservation.model.Employee;
import kz.iitu.reservation.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    public List<Employee> getListEmployee() {
        return employeeService.getListEmployee();
    }

    public Boolean login(Integer id, String psw) {
        return employeeService.login(id, psw);
    }

    public void addEmployee(Employee e) {
        employeeService.addEmployee(e);
    }

    public void deleteEmployee(Employee e, Integer id) {
        employeeService.deleteEmployee(e, id);
    }


}
