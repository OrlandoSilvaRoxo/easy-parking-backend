package br.easy.parking.repository.entity;

import br.easy.parking.model.CarModel;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Representa a entidade "Car" no banco de dados, associada a um veículo estacionado.
 */
@Entity
@Table(name = "car")
public class CarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "license_plate", nullable = false, unique = true)
    public String licensePlate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    public UserEntity user;

    @Column(name = "make", nullable = false)
    public String make;

    @Column(name = "model", nullable = false)
    public String model;

    @Column(name = "color", nullable = false)
    public String color;

    @Column(name = "parking_time")
    public LocalDateTime parkingTime;

    public CarEntity(CarModel carModel, UserEntity userEntity) {
        this.licensePlate = carModel.licensePlate;
        this.user = userEntity;
        this.make = carModel.make;
        this.model = carModel.model;
        this.color = carModel.color;
        this.parkingTime = carModel.parkingTime;
    }

    public CarEntity() {

    }
}
