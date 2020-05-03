//package kz.iitu.reservation.dao.mapper;
//
//import kz.iitu.reservation.model.Room;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.lang.Nullable;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class RoomMapper implements RowMapper<Room> {
//
//    @Nullable
//    @Override
//    public Room mapRow(ResultSet resultSet, int i) throws SQLException {
//        return new Room(
//                resultSet.getString("number")
//        );
//    }
//}
