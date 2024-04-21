package br.easy.parking.model;

import br.easy.parking.repository.entity.UserEntity;

import java.time.LocalDateTime;

public class CarModel {
    public Long id;

    public String licensePlate;

    public UserEntity user_id;

    public String make;

    public String model;

    public String color;

    public LocalDateTime parkingTime;
}
