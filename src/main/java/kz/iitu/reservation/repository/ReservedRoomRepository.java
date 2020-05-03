package kz.iitu.reservation.repository;

import kz.iitu.reservation.model.ReservedRooms;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservedRoomRepository extends JpaRepository<ReservedRooms, Long> {
}
