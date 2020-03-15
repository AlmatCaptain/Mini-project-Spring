package kz.iitu.reservation.dao;

import kz.iitu.reservation.dao.mapper.RoomMapper;
import kz.iitu.reservation.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RoomDao {

    @Autowired
    public JdbcTemplate jdbcTemplate;

    public List<Room> getAllRooms() {
        return jdbcTemplate.query("select * from room", new RoomMapper());
    }

}
