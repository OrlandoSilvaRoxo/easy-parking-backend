package br.easy.parking.repository.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Representa a entidade "User" no banco de dados, correspondente aos usuários do sistema de estacionamento.
 */
@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<CarEntity> cars;

}
