package br.easy.parking.repository.entity;

import br.easy.parking.model.UserModel;

import javax.persistence.*;
import java.util.List;

/**
 * Representa a entidade "User" no banco de dados, correspondente aos usuários do sistema de estacionamento.
 */
@Entity
@Table(name = "myUser")
public class UserEntity {

    public UserEntity(UserModel userModel){
        name = userModel.name;
        lastName = userModel.lastName;
        phone = userModel.phone;
        plate = userModel.plate;
        email = userModel.email;
        password = userModel.password;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "name", nullable = false, unique = true)
    public String name;

    @Column(name = "last_name", nullable = false, unique = true)
    public String lastName;

    @Column(name = "phone", nullable = false, unique = true)
    public String phone;

    @Column(name = "plate", nullable = false, unique = true)
    public String plate;

    @Column(name = "email", nullable = false, unique = true)
    public String email;

    @Column(name = "password", nullable = false)
    public String password;


    public UserEntity() {

    }
}
