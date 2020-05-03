package kz.iitu.reservation.events.handler;

import kz.iitu.reservation.events.ReserveRoomEvent;
import kz.iitu.reservation.model.ReservedRooms;
import org.springframework.context.ApplicationListener;

public class ReserveRoomHandler implements ApplicationListener<ReserveRoomEvent> {

    @Override
    public void onApplicationEvent(ReserveRoomEvent reserveRoomEvent) {
        ReservedRooms r = reserveRoomEvent.getReservedRooms();
        System.out.println("Room " + r.getRoomNumber() + " reserve by "
                + r.getEmployeeId() + " from " + r.getDate() + " to " + r.getToDate());
    }
}
