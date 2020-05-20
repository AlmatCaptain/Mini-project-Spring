package kz.iitu.reservation.service;

import kz.iitu.reservation.events.RemoveReserveEvent;
import kz.iitu.reservation.events.ReserveRoomEvent;
import kz.iitu.reservation.model.ReservedRooms;
import kz.iitu.reservation.repository.ReservedRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservedService implements ApplicationEventPublisherAware {

    private final ReservedRoomRepository reservedRepository;
    private ApplicationEventPublisher eventPublisher;

    @Autowired
    public ReservedService(ReservedRoomRepository reservedRepository) {
        this.reservedRepository = reservedRepository;
    }

    public List<ReservedRooms> getAllResRoom() {
        return reservedRepository.findAll();
    }

    public void addReserve(ReservedRooms reserve) {
        if (!getAllResRoom().contains(reserve)) {
            reservedRepository.saveAndFlush(reserve);
            this.eventPublisher.publishEvent(new ReserveRoomEvent(this, reserve));
        }
    }

    public void removeReserve(ReservedRooms reserve) {
        reservedRepository.delete(reserve);
        this.eventPublisher.publishEvent(new RemoveReserveEvent(this, reserve));
    }

    public ReservedRooms getReservesById(Long id) {
        return reservedRepository.findById(id)
                                 .get();
    }

    public void updateReserve(Long id, ReservedRooms reserve) {
        ReservedRooms room = reservedRepository.findById(id)
                                               .orElse(null);

        System.out.println("ReservedService.updateReserve "+ room.getId());
        if (room != null) {
            room.setId(id);
            room.setEmployeeId(reserve.getEmployeeId());
            room.setRoomNumber(reserve.getRoomNumber());
            room.setDate(reserve.getDate());
            room.setToDate(reserve.getToDate());

            reservedRepository.saveAndFlush(room);
        }
    }

    public List<ReservedRooms> getReservesByRoom(String num) {
        return reservedRepository.findAllByRoomNumber(num);
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }
}
