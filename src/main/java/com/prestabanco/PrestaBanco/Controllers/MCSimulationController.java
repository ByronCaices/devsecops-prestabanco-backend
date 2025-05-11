package com.prestabanco.PrestaBanco.Controllers;

import com.prestabanco.PrestaBanco.DTOs.Simulation.DTOSimulation;
import com.prestabanco.PrestaBanco.Services.IMCSimulationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/simulate")
public class MCSimulationController {

    @Autowired
    IMCSimulationService mcSimulationService;

    @PostMapping
    public ResponseEntity<DTOSimulation> simulateMortgageCredit(@RequestBody Map<String, Object> requestData){
        int loanAmount = (Integer) requestData.get("loanAmount");
        double annualInterestRate = ((Number) requestData.get("annualInterestRate")).doubleValue();
        int loanTerm = (Integer) requestData.get("loanTerm");
        DTOSimulation result = mcSimulationService.simulation(loanAmount,loanTerm,annualInterestRate);
        return ResponseEntity.ok(result);
    }

}
