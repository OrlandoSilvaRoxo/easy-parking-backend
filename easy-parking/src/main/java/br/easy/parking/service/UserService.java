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

    public void createUser(UserModel userModel) {
        UserEntity userEntity = new UserEntity(userModel);
        userRepository.createUser(userEntity);
    }

    public boolean login(String email) {
        UserEntity userEntity = userRepository.findUserByEmail(email);
        if (userEntity != null){
            return true;
        }
        return false;
    }
}
