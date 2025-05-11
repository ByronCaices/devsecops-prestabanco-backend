package com.prestabanco.PrestaBanco.Services;

import com.prestabanco.PrestaBanco.Entities.UserEntity;
import com.prestabanco.PrestaBanco.Entities.UserRoleEntity;
import com.prestabanco.PrestaBanco.Repositories.UserRepository;
import com.prestabanco.PrestaBanco.Repositories.UserRoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    UserRepository userRepository;
    UserRoleRepository userRoleRepository;

    @Autowired
    public UserService(UserRepository userRepository, UserRoleRepository userRoleRepository){
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
    }


    public List<UserEntity> getAll() {
        return new ArrayList<>(userRepository.findAll());
    }

    public UserEntity findById(Long id) {
        UserEntity user = userRepository.findById(id);
        if(user == null){
            return null;
        } else {
            return user;
        }
    }

    public UserEntity register(String name, String password, String role){
        if(userRepository.findByName(name)==null){
            UserRoleEntity userRoleEntity = userRoleRepository.findByRole(role);
            long roleID = userRoleEntity.getId();
            UserEntity user = new UserEntity(null, name, password,roleID);
            return userRepository.save(user);
        } else {
            return null;
        }
    }

    public UserEntity login(String name, String password){

        UserEntity user = userRepository.findByName(name);

        if(user!=null && user.getPassword().equals(password)){
            return user;
        } else {
            return null;
        }
    }
}
