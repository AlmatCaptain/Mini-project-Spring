package kz.iitu.reservation.repository;

import kz.iitu.reservation.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Role, Long> {
}
