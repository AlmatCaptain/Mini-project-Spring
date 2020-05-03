//package kz.iitu.reservation.dao.mapper;
//
//import kz.iitu.reservation.model.Employee;
//import org.springframework.jdbc.core.RowMapper;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class EmployeeMapper implements RowMapper<Employee> {
//
//    @Override
//    public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
//        return new Employee(
//                resultSet.getInt("id"),
//                resultSet.getString("name"),
//                resultSet.getString("password")
//        );
//    }
//}
