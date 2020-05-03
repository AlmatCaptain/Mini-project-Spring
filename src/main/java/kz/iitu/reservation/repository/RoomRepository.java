package kz.iitu.reservation.repository;

import kz.iitu.reservation.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, String> {
}
