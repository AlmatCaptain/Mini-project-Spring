package kz.iitu.reservation.dao;

import kz.iitu.reservation.dao.mapper.ReservedMapper;
import kz.iitu.reservation.model.ReservedRooms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReservedRoomDao {

    @Autowired
    public JdbcTemplate jdbcTemplate;

    public List<ReservedRooms> getAllReservedRoom() {
        return jdbcTemplate.query("select * from reservedrooms", new ReservedMapper());
    }

    public void addReserve(ReservedRooms reserve) {
        String query = "insert into reservedrooms(employeeid,roomnumber,date,todate) " +
                "values ('" + reserve.getEmployeeId() + "','" + reserve.getRoomNumber() + "','" + reserve.getDate() + "','"
                + reserve.getToDate() + "')";

        jdbcTemplate.execute(query);
    }

    public void removeReserve(ReservedRooms res) {
        String query = "delete from reservedrooms " +
                "where employeeid='" + res.getEmployeeId() + "' and roomnumber='" + res.getRoomNumber() +
                "' and date='" + res.getDate() + "'";
        jdbcTemplate.execute(query);
    }
}
