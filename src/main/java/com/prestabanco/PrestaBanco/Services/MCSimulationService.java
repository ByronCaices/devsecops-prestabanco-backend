package com.prestabanco.PrestaBanco.Services;

import org.springframework.stereotype.Service;

import com.prestabanco.PrestaBanco.DTOs.Simulation.DTOSimulation;

@Service
public class MCSimulationService implements IMCSimulationService {

    public double simulateMortgageCredit(int loanAmount, int loanTerm, double annualInterestRate){

        double monthly_rate = (annualInterestRate/12.0)/100.0;
        int months = loanTerm * 12;
        double aux=Math.pow((1+monthly_rate), months);
        double mortage = (loanAmount*((monthly_rate*aux)/(aux-1)));

        return Math.round(mortage * 100.0) / 100.0;
    }

    public DTOSimulation simulation(int loanAmount, int loanTerm, double annualInterestRate) {
        DTOSimulation simulation_result = new DTOSimulation();

        simulation_result.mounthly_payment = simulateMortgageCredit(loanAmount, loanTerm, annualInterestRate);

        simulation_result.lien_insurance = ((0.03)*simulation_result.mounthly_payment)/100;
        
        // It is always $20.000
        simulation_result.fire_insurance = 20000;

        // 1% of the loan ammount
        simulation_result.administration_commission = (1*loanAmount)/100;
        
        simulation_result.monthly_cost = 
            simulation_result.mounthly_payment + 
            simulation_result.lien_insurance + simulation_result.fire_insurance + 
            simulation_result.administration_commission;
        simulation_result.total_cost = simulation_result.monthly_cost * 12 * loanTerm;

        return simulation_result;
    }
}
