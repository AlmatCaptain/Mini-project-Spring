package kz.iitu.reservation.Controller;

import kz.iitu.reservation.model.ReservedRooms;
import kz.iitu.reservation.service.ReservedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReserveController {

    @Autowired
    private ReservedService reservedService;

    public List<ReservedRooms> getAllResRoom() {
        return reservedService.getAllResRoom();
    }

    public void addReserve(ReservedRooms reserve) {
        reservedService.addReserve(reserve);
    }

    public void removeReserve(ReservedRooms reserve) {
        reservedService.removeReserve(reserve);
    }

    public List<ReservedRooms> getReservesById(Integer id) {
        return reservedService.getReservesById(id);
    }

}
