package br.easy.parking.repository.interfaces;

import br.easy.parking.repository.entity.ParkingSpaceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Repositório para operações CRUD e consultas personalizadas relacionadas a entidades de ParkingSpace.
 */
public interface IParkingSpaceRepository extends JpaRepository<ParkingSpaceEntity, Long> {

    @Query("SELECT p FROM ParkingSpaceEntity p WHERE p.locationDescription = ?1")
    ParkingSpaceEntity findByLocationDescription(String locationDescription);

    @Query("SELECT p FROM ParkingSpaceEntity p WHERE p.isOccupied = true")
    List<ParkingSpaceEntity> findAllOccupied();

    @Query("SELECT p FROM ParkingSpaceEntity p WHERE p.isOccupied = false")
    List<ParkingSpaceEntity> findAllAvailable();
}
