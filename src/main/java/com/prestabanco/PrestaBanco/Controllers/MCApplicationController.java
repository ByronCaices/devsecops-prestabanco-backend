package com.prestabanco.PrestaBanco.Controllers;

import com.prestabanco.PrestaBanco.Entities.MCApplicationEntity;
import com.prestabanco.PrestaBanco.Entities.MCStatusEntity;
import com.prestabanco.PrestaBanco.Services.MCApplicationService;
import com.prestabanco.PrestaBanco.Services.MCStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mc-application")
public class MCApplicationController {

    @Autowired
    private MCApplicationService mcApplicationService;
    @Autowired
    private MCStatusService mcStatusService;

    @PostMapping
    public ResponseEntity<MCApplicationEntity> createMCApplication(@RequestBody MCApplicationEntity mcApplicationEntity) {
        MCApplicationEntity savedApplication = mcApplicationService.saveMCApplication(mcApplicationEntity);
        return ResponseEntity.ok(savedApplication);
    }

    @GetMapping("/getById/{clientId}")
    public ResponseEntity<MCApplicationEntity> getById(@PathVariable Long clientId) {
        MCApplicationEntity mcapplications = mcApplicationService.findById(clientId);
        return ResponseEntity.ok(mcapplications);
    }

    @GetMapping("/getAll/")
    public ResponseEntity<List<MCApplicationEntity>> getAll(){
        List<MCApplicationEntity> mcapplications = mcApplicationService.getAll();
        return ResponseEntity.ok(mcapplications);
    }

    @GetMapping("/getAllbyClient/{clientId}")
    public ResponseEntity<List<MCApplicationEntity>> getAllbyClient(@PathVariable Long clientId) {
        List<MCApplicationEntity> mcapplications = mcApplicationService.findAllbyClient(clientId);
        return ResponseEntity.ok(mcapplications);
    }

    @PutMapping("/updateStatus/{applicationId}")
    public ResponseEntity<?> updateApplicationStatus(@PathVariable Long applicationId, @RequestBody Long status) {
        MCApplicationEntity mcapplication = mcApplicationService.findById(applicationId);

        if(mcapplication==null){
            return ResponseEntity.notFound().build();
        }

        mcapplication.setStatus(status);
        mcApplicationService.saveMCApplication(mcapplication);

        return ResponseEntity.ok(mcapplication);
    }

    @GetMapping("/status/getAll/")
    public ResponseEntity<List<MCStatusEntity>> getAllstatus() {
        List<MCStatusEntity> mcStatusEntities = mcStatusService.getAllstatus();
        return ResponseEntity.ok(mcStatusEntities);
    }

}