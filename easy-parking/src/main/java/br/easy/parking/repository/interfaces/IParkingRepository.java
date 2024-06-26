package br.easy.parking.repository.interfaces;

import br.easy.parking.repository.entity.ParkingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

public interface IParkingRepository extends JpaRepository<ParkingEntity, Long> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO parking (occupied) VALUES (false)", nativeQuery = true)
    void createParking();

    @Modifying
    @Transactional
    @Query(value = "UPDATE parking SET occupied = false WHERE id = ?1", nativeQuery = true)
    void freeParking(Long parkingId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE parking SET occupied = true, plate = ?2, start_time = ?3, end_time = ?4 WHERE id = ?1", nativeQuery = true)
    void occupyParking(Long id, String plate, LocalDateTime startTime, LocalDateTime endTime);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM parking WHERE id = ?1", nativeQuery = true)
    void deleteParking(Long id);
}
