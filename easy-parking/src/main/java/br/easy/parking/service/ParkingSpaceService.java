package br.easy.parking.service;

import br.easy.parking.repository.ParkingSpaceRepository;
import br.easy.parking.repository.entity.ParkingSpaceEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingSpaceService {

    @Autowired
    private ParkingSpaceRepository parkingSpaceRepository;

    public ParkingSpaceEntity createParkingSpace(ParkingSpaceEntity parkingSpaceEntity) {
        return parkingSpaceRepository.createParkingSpace(parkingSpaceEntity);
    }

    public ParkingSpaceEntity getParkingSpaceByLocation(String locationDescription) {
        return parkingSpaceRepository.findParkingSpaceByLocation(locationDescription);
    }

    public List<ParkingSpaceEntity> getAllOccupiedSpaces() {
        return parkingSpaceRepository.findAllOccupiedSpaces();
    }

    public List<ParkingSpaceEntity> getAllAvailableSpaces() {
        return parkingSpaceRepository.findAllAvailableSpaces();
    }

    public ParkingSpaceEntity updateParkingSpace(Long id, ParkingSpaceEntity parkingSpaceEntity) {
        return parkingSpaceRepository.updateParkingSpace(id, parkingSpaceEntity);
    }

    public void deleteParkingSpace(Long id) {
        parkingSpaceRepository.deleteParkingSpace(id);
    }

    public List<ParkingSpaceEntity> getAllParkingSpaces() {
        return parkingSpaceRepository.findAllParkingSpaces();
    }
}
