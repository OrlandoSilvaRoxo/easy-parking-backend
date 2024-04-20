package br.easy.parking.repository;

import br.easy.parking.repository.entity.CarEntity;
import br.easy.parking.repository.interfaces.ICarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarRepository {

    @Autowired
    private ICarRepository iCarRepository;

    public CarEntity createCar(CarEntity carEntity) {
        return iCarRepository.save(carEntity);
    }

    public CarEntity findCarByLicensePlate(String licensePlate) {
        return iCarRepository.findByLicensePlate(licensePlate);
    }

    public List<CarEntity> findAllCarsByUserId(Long userId) {
        return iCarRepository.findAllByUserId(userId);
    }

    public CarEntity updateCar(Long id, CarEntity carEntity) {
        if (iCarRepository.existsById(id)) {
            carEntity.id = id;
            return iCarRepository.save(carEntity);
        }
        return null;
    }

    public void deleteCar(Long id) {
        iCarRepository.deleteById(id);
    }

    public List<CarEntity> findAllCars() {
        return iCarRepository.findAll();
    }
}
