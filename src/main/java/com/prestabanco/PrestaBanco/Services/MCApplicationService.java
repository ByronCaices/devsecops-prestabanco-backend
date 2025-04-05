package com.prestabanco.PrestaBanco.Services;

import com.prestabanco.PrestaBanco.Entities.MCApplicationEntity;
import com.prestabanco.PrestaBanco.Repositories.MCApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MCApplicationService {

    @Autowired
    private MCApplicationRepository mcApplicationRepository;

    public MCApplicationEntity saveMCApplication(MCApplicationEntity mcApplicationEntity) {
        return mcApplicationRepository.save(mcApplicationEntity);
    }

    public List<MCApplicationEntity> getAll(){
        return mcApplicationRepository.findAll();
    }

    public MCApplicationEntity findById(Long id){
        return mcApplicationRepository.findById(id).orElse(null);
    }

    public List<MCApplicationEntity> findAllbyClient(Long Id){
        return mcApplicationRepository.findAllByClient(Id);
    }

}