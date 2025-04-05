package com.prestabanco.PrestaBanco.Repositories;

import com.prestabanco.PrestaBanco.Entities.MCApplicationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MCApplicationRepository extends JpaRepository<MCApplicationEntity, Long> {

    List<MCApplicationEntity> findAllByClient(Long client);
}