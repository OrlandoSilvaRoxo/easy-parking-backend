package br.easy.parking.repository;

import br.easy.parking.repository.entity.ParkingEntity;
import br.easy.parking.repository.interfaces.IParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ParkingRepository {
    @Autowired
    private IParkingRepository iParkingRepository;

    public boolean createParking() {
        try {
            iParkingRepository.createParking();
            return true;
        } catch (Exception e) {
            System.out.println("Falha ao inserir a vaga de estacionamento: " + e.getMessage());
            return false;
        }
    }

    public List<ParkingEntity> getAllParkings() {
        return iParkingRepository.findAll(); // Retorna todos os estacionamentos cadastrados no banco de dados.
    }

    public boolean occupyAParkingSlot(Long parkingId) {
        try {
            iParkingRepository.occupyParking(parkingId);
            return true;
        } catch (Exception e) {
            System.out.println("Falha ao inserir a vaga de estacionamento: " + e.getMessage());
            return false;
        }
    }

    public boolean freeAParkingSlot(Long parkingId) {
        try {
            iParkingRepository.freeParking(parkingId);
            return true;
        } catch (Exception e) {
            System.out.println("Falha ao inserir a vaga de estacionamento: " + e.getMessage());
            return false;
        }
    }
}
