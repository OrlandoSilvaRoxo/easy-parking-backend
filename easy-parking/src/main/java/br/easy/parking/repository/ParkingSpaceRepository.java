package br.easy.parking.repository;

import br.easy.parking.repository.entity.ParkingSpaceEntity;
import br.easy.parking.repository.interfaces.IParkingSpaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ParkingSpaceRepository {

    @Autowired
    private IParkingSpaceRepository iParkingSpaceRepository;

    public ParkingSpaceEntity createParkingSpace(ParkingSpaceEntity parkingSpaceEntity) {
        return iParkingSpaceRepository.save(parkingSpaceEntity);
    }

    public ParkingSpaceEntity findParkingSpaceByLocation(String locationDescription) {
        return iParkingSpaceRepository.findByLocationDescription(locationDescription);
    }

    public List<ParkingSpaceEntity> findAllOccupiedSpaces() {
        return iParkingSpaceRepository.findAllOccupied();
    }

    public List<ParkingSpaceEntity> findAllAvailableSpaces() {
        return iParkingSpaceRepository.findAllAvailable();
    }

    public ParkingSpaceEntity updateParkingSpace(Long id, ParkingSpaceEntity parkingSpaceEntity) {
        if (iParkingSpaceRepository.existsById(id)) {
            parkingSpaceEntity.id = id;
            return iParkingSpaceRepository.save(parkingSpaceEntity);
        }
        return null;
    }

    public void deleteParkingSpace(Long id) {
        iParkingSpaceRepository.deleteById(id);
    }

    public List<ParkingSpaceEntity> findAllParkingSpaces() {
        return iParkingSpaceRepository.findAll();
    }
}
