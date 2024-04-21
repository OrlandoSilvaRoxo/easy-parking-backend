package br.easy.parking.repository;

import br.easy.parking.repository.entity.UserEntity;
import br.easy.parking.repository.interfaces.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    private IUserRepository iUserRepository;

    public UserEntity createUser(UserEntity userEntity) {
        return iUserRepository.save(userEntity);
    }

    public UserEntity findUserByUsername(String username) {
        return iUserRepository.findByUsername(username);
    }

    public UserEntity findUserByEmail(String email) {
        return iUserRepository.findByEmail(email);
    }

    public UserEntity updateUser(Long id, UserEntity userEntity) {
        if (iUserRepository.existsById(id)) {
            userEntity.id = id;
            return iUserRepository.save(userEntity);
        }
        return null;
    }

    public void deleteUser(Long id) {
        iUserRepository.deleteById(id);
    }

    public List<UserEntity> findAllUsers() {
        return iUserRepository.findAll();
    }

    public UserEntity findUserById(Long id) {return iUserRepository.getById(id);}
}
