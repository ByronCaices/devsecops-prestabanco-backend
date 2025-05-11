package com.prestabanco.PrestaBanco.Controllers;

import com.prestabanco.PrestaBanco.Entities.MCApplicationEntity;

import com.prestabanco.PrestaBanco.Services.TotalCostCalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/totalcost")
public class TotalCostCalculationController {

    @Autowired
    TotalCostCalculationService totalCostCalculationService;

    @PostMapping
    public ResponseEntity<List<Double>> totalCostCalculation(
            @RequestBody MCApplicationEntity mcApplicationEntity){
        List<Double> result = totalCostCalculationService.totalCostCalculation(mcApplicationEntity);
        return ResponseEntity.ok(result);
    }
}
