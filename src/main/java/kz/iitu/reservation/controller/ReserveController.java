package kz.iitu.reservation.controller;

import kz.iitu.reservation.model.ReservedRooms;
import kz.iitu.reservation.service.ReservedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reserves")
public class ReserveController {

    private final ReservedService reservedService;

    @Autowired
    public ReserveController(ReservedService reservedService) {
        this.reservedService = reservedService;
    }

    @GetMapping
    public List<ReservedRooms> getAllResRoom() {
        return reservedService.getAllResRoom();
    }

    @PostMapping("/add")
    public void addReserve(@RequestBody ReservedRooms reserve) {
        reservedService.addReserve(reserve);
    }

    @DeleteMapping("/delete")
    public void removeReserve(@RequestBody ReservedRooms reserve) {
        reservedService.removeReserve(reserve);
    }

    @PutMapping("/update/{id}")
    public void updateMember(@PathVariable Long id, @RequestBody ReservedRooms reserve) {
        reserve.setId(id);
        reservedService.updateReserve(id, reserve);
    }

    @GetMapping("/{id}")
    public ReservedRooms getReserveById(@PathVariable Long id) {
        return reservedService.getReservesById(id);
    }

}
