package kz.iitu.reservation.service;

import kz.iitu.reservation.dao.ReservedRoomDao;
import kz.iitu.reservation.events.RemoveReserveEvent;
import kz.iitu.reservation.events.ReserveRoomEvent;
import kz.iitu.reservation.model.ReservedRooms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ReservedService implements ApplicationEventPublisherAware {

    @Autowired
    public ReservedRoomDao reservedRoomDao;
    private ApplicationEventPublisher eventPublisher;

    public List<ReservedRooms> getAllResRoom() {
        for (ReservedRooms r : reservedRoomDao.getAllReservedRoom())
            System.out.println(r);
        return reservedRoomDao.getAllReservedRoom();
    }

    public void addReserve(ReservedRooms reserve) {
        if (!getAllResRoom().contains(reserve)) {
            reservedRoomDao.addReserve(reserve);
            this.eventPublisher.publishEvent(new ReserveRoomEvent(this, reserve));
        }

    }

    public void removeReserve(ReservedRooms reserve) {
        reservedRoomDao.removeReserve(reserve);
        this.eventPublisher.publishEvent(new RemoveReserveEvent(this, reserve));
    }

    public List<ReservedRooms> getReservesById(Integer id) {
        List<ReservedRooms> list = new ArrayList<>();

        for (ReservedRooms r : getAllResRoom()) {
            if (r.getEmployeeId() == id)
                list.add(r);
        }

        for (ReservedRooms r : list)
            System.out.println(r);

        return list;
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }
}
