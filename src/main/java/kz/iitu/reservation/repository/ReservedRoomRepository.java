package kz.iitu.reservation.repository;

import kz.iitu.reservation.model.ReservedRooms;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservedRoomRepository extends JpaRepository<ReservedRooms, Long> {
    List<ReservedRooms> findAllByRoomNumber(String num);
}
