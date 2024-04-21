package br.easy.parking.controller;

import br.easy.parking.repository.entity.ParkingSpaceEntity;
import br.easy.parking.service.ParkingSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parkingspace")
public class ParkingSpaceController {

    @Autowired
    ParkingSpaceService parkingSpaceService;

    @PostMapping
    public ParkingSpaceEntity createParkingSpace(@RequestBody ParkingSpaceEntity parkingSpaceEntity) {
        return parkingSpaceService.createParkingSpace(parkingSpaceEntity);
    }

    @GetMapping("/{locationDescription}")
    public ParkingSpaceEntity getParkingSpaceByLocation(@PathVariable String locationDescription) {
        return parkingSpaceService.getParkingSpaceByLocation(locationDescription);
    }

    @GetMapping("/occupied")
    public List<ParkingSpaceEntity> getAllOccupiedSpaces() {
        return parkingSpaceService.getAllOccupiedSpaces();
    }

    @GetMapping("/available")
    public List<ParkingSpaceEntity> getAllAvailableSpaces() {
        return parkingSpaceService.getAllAvailableSpaces();
    }

    @PutMapping("/{id}")
    public ParkingSpaceEntity updateParkingSpace(@PathVariable Long id, @RequestBody ParkingSpaceEntity parkingSpaceEntity) {
        return parkingSpaceService.updateParkingSpace(id, parkingSpaceEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteParkingSpace(@PathVariable Long id) {
        parkingSpaceService.deleteParkingSpace(id);
    }

    @GetMapping
    public List<ParkingSpaceEntity> getAllParkingSpaces() {
        return parkingSpaceService.getAllParkingSpaces();
    }
}
