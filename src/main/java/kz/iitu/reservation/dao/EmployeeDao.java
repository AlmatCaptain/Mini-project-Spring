//package kz.iitu.reservation.dao;
//
//import kz.iitu.reservation.dao.mapper.EmployeeMapper;
//import kz.iitu.reservation.model.Employee;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
//@Component
//public class EmployeeDao {
//
//    @Autowired
//    public JdbcTemplate jdbcTemplate;
//
//    public List<Employee> getAllEmployee() {
//        return jdbcTemplate.query("select * from employee", new EmployeeMapper());
//    }
//
//    public Employee login(Long id) {
//        Boolean empty = jdbcTemplate.query("select * from employee where id='" + id + "'", new EmployeeMapper())
//                                    .isEmpty();
//        if (!empty)
//            return jdbcTemplate.query("select * from employee where id='" + id + "'", new EmployeeMapper())
//                               .get(0);
//        return null;
//    }
//
//    public void addEmployee(Employee e) {
//        String query = "insert into employee(id,name,password) values ('" + e.getId() + "','" + e.getName() + "','" + e.getPassword() + "')";
//        jdbcTemplate.execute(query);
//    }
//
//    public void deleteEmployeeById(Integer id) {
//        String query = "delete from employee where id='" + id + "'";
//
//        jdbcTemplate.execute(query);
//    }
//
//
//}
