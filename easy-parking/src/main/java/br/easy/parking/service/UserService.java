package br.easy.parking.service;

import br.easy.parking.model.UserModel;
import br.easy.parking.repository.UserRepository;
import br.easy.parking.repository.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean createUser(UserModel userModel) {
        UserEntity userEntity = new UserEntity(userModel);
        try {
            userRepository.createUser(userEntity);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean login(String email, String password) {
        UserEntity userEntity = userRepository.findUserByEmail(email);
        if (userEntity != null && userEntity.password.equals(password)){
            return true;
        }
        return false;
    }

    public boolean isAdmin(String email) {
        UserEntity userEntity = userRepository.findUserByEmail(email);
        if (userEntity != null && userEntity.isAdmin == true){
            return true;
        }
        return false;
    }

    public List<UserEntity> getAllUsers() {
        return userRepository.findAllUsers();
    }

    public boolean updateUser(Long id, UserModel userModel) {
        return userRepository.updateUser(id, userModel);
    }

    public boolean deleteUser(Long id) {
        return userRepository.deleteUser(id);
    }

    public boolean toggleAdminStatus(Long id) {
        return userRepository.toggleAdminStatus(id);
    }
}
