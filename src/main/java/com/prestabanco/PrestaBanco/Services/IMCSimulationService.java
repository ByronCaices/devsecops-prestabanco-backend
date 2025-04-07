package com.prestabanco.PrestaBanco.Services;

import java.util.List;


/**
 * Provides the simulation of mortages.
 */
public interface IMCSimulationService {
    /**
     * Returns the simulated mortage credit amount.
     * @param loanAmount
     * @param loanTerm
     * @param annualInterestRate
     * @return
     */
    public double simulateMortgageCredit(int loanAmount, int loanTerm, double annualInterestRate);

    /**
     * Returns various mortage credit information.
     * @param loanAmount
     * @param loanterm
     * @param annualInterestRate
     * @return
     */
    public List<Double> simulation(int loanAmount, int loanterm, double annualInterestRate);
}
