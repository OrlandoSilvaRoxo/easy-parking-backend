package br.easy.parking.repository;

import br.easy.parking.repository.entity.UserEntity;
import br.easy.parking.repository.interfaces.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    @Autowired
    private IUserRepository iUserRepository;

    public void createUser(UserEntity userEntity) {
        iUserRepository.insertUser(userEntity.name, userEntity.lastName, userEntity.phone, userEntity.plate, userEntity.email, userEntity.password);
    }

    public UserEntity findUserByEmail(String email) {
        return iUserRepository.findByEmail(email);
    }
}
