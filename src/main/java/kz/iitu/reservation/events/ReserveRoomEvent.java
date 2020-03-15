package kz.iitu.reservation.events;

import kz.iitu.reservation.model.ReservedRooms;
import org.springframework.context.ApplicationEvent;

public class ReserveRoomEvent  extends ApplicationEvent  {

    private ReservedRooms reservedRooms;

    public ReserveRoomEvent(Object source, ReservedRooms reservedRooms) {
        super(source);
        this.reservedRooms = reservedRooms;
    }

    public ReservedRooms getReservedRooms() {
        return reservedRooms;
    }
}
