package br.easy.parking.repository.interfaces;

import br.easy.parking.repository.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Repositório para operações CRUD e consultas personalizadas relacionadas a entidades de Car.
 */
public interface ICarRepository extends JpaRepository<CarEntity, Long> {

    @Query("SELECT c FROM CarEntity c WHERE c.licensePlate = ?1")
    CarEntity findByLicensePlate(String licensePlate);

    @Query("SELECT c FROM CarEntity c WHERE c.user.id = ?1")
    List<CarEntity> findAllByUserId(Long userId);
}
