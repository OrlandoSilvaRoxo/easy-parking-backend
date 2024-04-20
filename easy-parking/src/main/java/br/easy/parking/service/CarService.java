package br.easy.parking.service;

import br.easy.parking.repository.CarRepository;
import br.easy.parking.repository.entity.CarEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public CarEntity createCar(CarEntity carEntity) {
        return carRepository.createCar(carEntity);
    }

    public CarEntity getCarByLicensePlate(String licensePlate) {
        return carRepository.findCarByLicensePlate(licensePlate);
    }

    public List<CarEntity> getAllCarsByUserId(Long userId) {
        return carRepository.findAllCarsByUserId(userId);
    }

    public CarEntity updateCar(Long id, CarEntity carEntity) {
        return carRepository.updateCar(id, carEntity);
    }

    public void deleteCar(Long id) {
        carRepository.deleteCar(id);
    }

    public List<CarEntity> getAllCars() {
        return carRepository.findAllCars();
    }
}
