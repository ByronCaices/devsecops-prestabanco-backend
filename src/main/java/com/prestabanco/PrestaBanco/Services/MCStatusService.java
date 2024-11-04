package com.prestabanco.PrestaBanco.Services;

import com.prestabanco.PrestaBanco.Entities.MCStatusEntity;
import com.prestabanco.PrestaBanco.Repositories.MCStatusRepository;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MCStatusService {

    @Autowired
    MCStatusRepository mcStatusRepository;

    @PostConstruct
    public void init() {
        createStatusIfNotFound("Envío Pendiente");
        createStatusIfNotFound("En Revisión Inicial");
        createStatusIfNotFound("Pendiente de Documentación");
        createStatusIfNotFound("En Evaluación");
        createStatusIfNotFound("Pre-Aprobada");
        createStatusIfNotFound("En Aprobación Final");
        createStatusIfNotFound("Aprobada");
        createStatusIfNotFound("Rechazada");
        createStatusIfNotFound("Cancelada por el Cliente");
        createStatusIfNotFound("En Desembolso");
    }

    private void createStatusIfNotFound(String status){
        if(mcStatusRepository.findByStatus(status)==null){
            MCStatusEntity mcStatusEntity = new MCStatusEntity();
            mcStatusEntity.setStatus(status);
            mcStatusRepository.save(mcStatusEntity);
        }
    }

}
