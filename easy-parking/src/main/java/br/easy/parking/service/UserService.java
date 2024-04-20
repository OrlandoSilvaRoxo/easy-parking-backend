package br.easy.parking.service;

import br.easy.parking.repository.UserRepository;
import br.easy.parking.repository.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity createUser(UserEntity userEntity) {
        return userRepository.createUser(userEntity);
    }

    public UserEntity getUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    public UserEntity getUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    public UserEntity updateUser(Long id, UserEntity userEntity) {
        return userRepository.updateUser(id, userEntity);
    }

    public void deleteUser(Long id) {
        userRepository.deleteUser(id);
    }

    public List<UserEntity> getAllUsers() {
        return userRepository.findAllUsers();
    }
}
