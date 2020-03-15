package kz.iitu.reservation.Controller;

import kz.iitu.reservation.model.Room;
import kz.iitu.reservation.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RoomController {

    @Autowired
    private RoomService roomService;

    public List<Room> getAllRooms() {
        System.out.println("SFDD");
        return roomService.getAllRooms();
    }
}
