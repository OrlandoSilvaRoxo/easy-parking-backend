package br.easy.parking.controller;

import br.easy.parking.model.CarModel;
import br.easy.parking.repository.entity.CarEntity;
import br.easy.parking.service.CarService;
import br.easy.parking.utils.SwaggerExamples;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
@Tag(name = "car-controller", description = "Controller responsável por requisições de carros")
public class CarController {

    @Autowired
    CarService carService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CarEntity createCar(@RequestBody CarModel carModel) {
        return carService.createCar(carModel);
    }

    @GetMapping("/{licensePlate}")
    public CarEntity getCarByLicensePlate(@PathVariable String licensePlate) {
        return carService.getCarByLicensePlate(licensePlate);
    }

    @GetMapping("/user/{userId}")
    public List<CarEntity> getAllCarsByUserId(@PathVariable Long userId) {
        return carService.getAllCarsByUserId(userId);
    }

    @PutMapping("/{id}")
    public CarEntity updateCar(@PathVariable Long id, @RequestBody CarEntity carEntity) {
        return carService.updateCar(id, carEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
    }

    @GetMapping
    public List<CarEntity> getAllCars() {
        return carService.getAllCars();
    }
}
