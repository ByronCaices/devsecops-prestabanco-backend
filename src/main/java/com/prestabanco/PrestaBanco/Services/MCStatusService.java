package com.prestabanco.PrestaBanco.Services;

import com.prestabanco.PrestaBanco.Entities.MCStatusEntity;
import com.prestabanco.PrestaBanco.Repositories.MCStatusRepository;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MCStatusService {

    @Autowired
    MCStatusRepository mcStatusRepository;

    public List<MCStatusEntity> getAllstatus() {
        return new ArrayList<>(mcStatusRepository.findAll());
    }

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
            mcStatusRepository.save(new MCStatusEntity(null, status));
        }
    }

}
