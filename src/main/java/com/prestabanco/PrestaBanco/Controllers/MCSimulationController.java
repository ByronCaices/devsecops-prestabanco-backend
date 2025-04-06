package com.prestabanco.PrestaBanco.Controllers;

import com.prestabanco.PrestaBanco.Services.MCSimulationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.List;

@RestController
@RequestMapping("/simulate")
@CrossOrigin("*")
public class MCSimulationController {

    @Autowired
    MCSimulationService mcSimulationService;

    @PostMapping
    public ResponseEntity<List<Double>> simulateMortgageCredit(@RequestBody Map<String, Object> requestData){
        int loanAmount = (Integer) requestData.get("loanAmount");
        double annualInterestRate = ((Number) requestData.get("annualInterestRate")).doubleValue();
        int loanTerm = (Integer) requestData.get("loanTerm");
        List<Double> result = mcSimulationService.simulation(loanAmount,loanTerm,annualInterestRate);
        return ResponseEntity.ok(result);
    }

}
