package br.easy.parking.repository.entity;

import br.easy.parking.model.UserModel;

import javax.persistence.*;
import java.util.List;

/**
 * Representa a entidade "User" no banco de dados, correspondente aos usuários do sistema de estacionamento.
 */
@Entity
@Table(name = "user")
public class UserEntity {

    public UserEntity(UserModel userModel){
        id = userModel.id;
        username = userModel.username;
        password = userModel.password;
        email = userModel.email;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "username", nullable = false, unique = true)
    public String username;

    @Column(name = "password", nullable = false)
    public String password;

    @Column(name = "email", nullable = false, unique = true)
    public String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    public List<CarEntity> cars;

    public UserEntity() {

    }
}
