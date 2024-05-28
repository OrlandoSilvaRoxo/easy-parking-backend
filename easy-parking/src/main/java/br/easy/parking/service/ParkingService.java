package br.easy.parking.service;

import br.easy.parking.model.ParkingModel;
import br.easy.parking.repository.ParkingRepository;
import br.easy.parking.repository.entity.ParkingEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingService {
    @Autowired
    private ParkingRepository parkingRepository;

    public boolean createParking() {
        try {
            parkingRepository.createParking();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<ParkingEntity> getAllParkings() {
        return parkingRepository.getAllParkings(); // Retorna todos os estacionamentos cadastrados no banco de dados.
    }

    public boolean occupyParking(ParkingModel parkingModel) {
        return parkingRepository.occupyAParkingSlot(parkingModel);
    }

    public boolean freeParking(Long parkingId) {
        return parkingRepository.freeAParkingSlot(parkingId);
    }

    public boolean deleteParking(Long id) {
        return parkingRepository.deleteParking(id);
    }
}
