package kz.iitu.reservation.service;

import kz.iitu.reservation.dao.EmployeeDao;
import kz.iitu.reservation.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public class EmployeeService {

    @Autowired
    public EmployeeDao employeeDao;

    public List<Employee> getListEmployee() {
        return employeeDao.getAllEmployee();
    }

    public Boolean login(Integer id, String psw){
        Employee e = employeeDao.login(id);
        if(e.getId() == id && e.getPassword().equals(psw))
            return true;
        return false;
    }

    public void addEmployee(Employee e) {
        if (!getListEmployee().contains(e))
            employeeDao.addEmployee(e);
    }

    public void deleteEmployee(Employee e, Integer id) {
        if (employeeDao.getAllEmployee().contains(e)) {
            employeeDao.deleteEmployeeById(id);
        } else
            System.out.println("User not find");

    }


}
