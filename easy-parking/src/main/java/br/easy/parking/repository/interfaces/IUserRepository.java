package br.easy.parking.repository.interfaces;

import br.easy.parking.repository.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

/**
 * Repositório para operações CRUD e consultas personalizadas relacionadas a entidades de User.
 */
public interface IUserRepository extends JpaRepository<UserEntity, Long> {

    @Query("SELECT u FROM UserEntity u WHERE u.email = ?1")
    UserEntity findByEmail(String email);

    /**
     * Insere um novo usuário no banco de dados utilizando uma consulta SQL nativa.
     */
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO user (name, last_name, phone, plate, email, password) VALUES (?1, ?2, ?3, ?4, ?5, ?6)", nativeQuery = true)
    void insertUser(String name, String lastName, String phone, String plate, String email, String password);
}
