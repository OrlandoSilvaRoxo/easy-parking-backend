package br.easy.parking.repository.interfaces;

import br.easy.parking.repository.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Repositório para operações CRUD e consultas personalizadas relacionadas a entidades de User.
 */
public interface IUserRepository extends JpaRepository<UserEntity, Long> {

    @Query("SELECT u FROM UserEntity u WHERE u.email = ?1")
    UserEntity findByEmail(String email);


    /**
     * Insere um novo usuário no banco de dados utilizando uma consulta SQL nativa.
     */
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO my_user (name, last_name, phone, plate, email, password, is_admin) VALUES (?1, ?2, ?3, ?4, ?5, ?6, false)", nativeQuery = true)
    void insertUser(String name, String lastName, String phone, String plate, String email, String password);

    /**
     * Atualiza um usuário no banco de dados utilizando uma consulta SQL nativa.
     */
    @Modifying
    @Transactional
    @Query(value = "UPDATE my_user SET name = ?2, last_name = ?3, phone = ?4, plate = ?5, email = ?6, password = ?7 WHERE id = ?1", nativeQuery = true)
    void updateUser(Long id, String name, String lastName, String phone, String plate, String email, String password);

    /**
     * Deleta um usuário no banco de dados utilizando uma consulta SQL nativa.
     */
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM my_user WHERE id = ?1", nativeQuery = true)
    void deleteUser(Long id);

    /**
     * Alterna o status de administrador de um usuário no banco de dados utilizando uma consulta SQL nativa.
     */
    @Modifying
    @Transactional
    @Query(value = "UPDATE my_user SET is_admin = CASE WHEN is_admin = true THEN false ELSE true END WHERE id = ?1", nativeQuery = true)
    void toggleAdminStatus(Long id);

    /**
     * Obtém todos os usuários do banco de dados utilizando uma consulta SQL nativa.
     */
    @Query(value = "SELECT * FROM my_user", nativeQuery = true)
    List<UserEntity> findAllUsers();
}
