package br.easy.parking.repository;

import br.easy.parking.model.UserModel;
import br.easy.parking.repository.entity.UserEntity;
import br.easy.parking.repository.interfaces.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    public List<UserEntity> findAllUsers(){
        return iUserRepository.findAllUsers();
    }

    public boolean updateUser(Long id, UserModel userModel){
        try {
            iUserRepository.updateUser(
                    id,
                    userModel.name,
                    userModel.lastName,
                    userModel.phone,
                    userModel.plate,
                    userModel.email,
                    userModel.password
            );
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean deleteUser(Long id) {
        try {
            iUserRepository.deleteUser(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean toggleAdminStatus(Long id) {
        try {
            iUserRepository.toggleAdminStatus(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
