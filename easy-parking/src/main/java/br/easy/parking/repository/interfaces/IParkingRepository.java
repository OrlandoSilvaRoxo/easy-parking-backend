package br.easy.parking.repository.interfaces;

import br.easy.parking.repository.entity.ParkingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface IParkingRepository extends JpaRepository<ParkingEntity, Long> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO parking (occupied) VALUES (false)", nativeQuery = true)
    void createParking();

    @Modifying
    @Transactional
    @Query(value = "UPDATE parking SET occupied = true WHERE id = ?1", nativeQuery = true)
    void occupyParking(Long parkingId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE parking SET occupied = false WHERE id = ?1", nativeQuery = true)
    void freeParking(Long parkingId);
}
