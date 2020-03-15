package kz.iitu.reservation.service;

import kz.iitu.reservation.dao.RoomDao;
import kz.iitu.reservation.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class RoomService {

    @Autowired
    public RoomDao roomDao;

    public List<Room> getAllRooms() {
        for (Room r: roomDao.getAllRooms())
            System.out.println(r);
        return roomDao.getAllRooms();
    }

}
