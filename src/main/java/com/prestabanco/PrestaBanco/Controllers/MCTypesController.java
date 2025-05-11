package com.prestabanco.PrestaBanco.Controllers;

import com.prestabanco.PrestaBanco.Entities.MCTypesEntity;
import com.prestabanco.PrestaBanco.Services.MCTypesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mc-types")
public class MCTypesController {

    @Autowired
    MCTypesService mcTypesService;

    @GetMapping("/getAll")
    public ResponseEntity<List<MCTypesEntity>> getAll() {
        List<MCTypesEntity> mcTypesEntities = mcTypesService.getAll();
        return ResponseEntity.ok(mcTypesEntities);
    }

}
