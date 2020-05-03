package kz.iitu.reservation.repository;

import kz.iitu.reservation.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findByUsername(String name);
}
