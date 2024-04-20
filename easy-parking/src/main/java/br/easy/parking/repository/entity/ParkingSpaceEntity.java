package br.easy.parking.repository.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Representa a entidade "ParkingSpace" no banco de dados, que detalha cada espaço de estacionamento disponível.
 */
@Entity
@Table(name = "parking_space")
@EntityListeners(AuditingEntityListener.class)
public class ParkingSpaceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "location_description", nullable = false)
    public String locationDescription;

    @Column(name = "is_occupied", nullable = false)
    public boolean isOccupied;

    @Column(name = "occupy_time")
    public LocalDateTime occupyTime;
}
