package com.prestabanco.PrestaBanco.Repositories;

import com.prestabanco.PrestaBanco.Entities.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

        UserEntity findByName(String name);
        UserEntity findById(Long id);
}
