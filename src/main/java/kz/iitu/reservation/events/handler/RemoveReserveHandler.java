package kz.iitu.reservation.events.handler;

import kz.iitu.reservation.events.RemoveReserveEvent;
import kz.iitu.reservation.model.ReservedRooms;
import org.springframework.context.ApplicationListener;

public class RemoveReserveHandler implements ApplicationListener<RemoveReserveEvent> {

    @Override
    public void onApplicationEvent(RemoveReserveEvent removeReserveEvent) {
        ReservedRooms r = removeReserveEvent.getReservedRooms();
        System.out.println("Employee " + r.getEmployeeId() + " removed reserved room "
                + r.getRoomNumber() + " on " + r.getDate());
    }
}
