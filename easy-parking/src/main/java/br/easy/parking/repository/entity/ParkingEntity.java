package br.easy.parking.repository.entity;

import javax.persistence.*;

@Entity
@Table(name = "parking")
public class ParkingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "occupied", nullable = false)
    public boolean occupied;
}
