package com.prestabanco.PrestaBanco.Services;

import java.util.List;

import com.prestabanco.PrestaBanco.DTOs.Simulation.DTOSimulation;


/**
 * Provides the simulation of mortages.
 */
public interface IMCSimulationService {
    /**
     * Returns the simulated monthly mortage.
     * @param loanAmount
     * @param loanTerm
     * @param annualInterestRate
     * @return
     */
    public double simulateMortgageCredit(int loanAmount, int loanTerm, double annualInterestRate);

    /**
     * Returns various mortage information.
     * @param loanAmount
     * @param loanterm
     * @param annualInterestRate
     * @return
     */
    public DTOSimulation simulation(int loanAmount, int loanterm, double annualInterestRate);
}
