package com.prestabanco.PrestaBanco.Services;

import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Arrays;
import java.util.List;

@Service
public class MCSimulationService implements IMCSimulationService {

    public double simulateMortgageCredit(int loanAmount, int loanTerm, double annualInterestRate){

        double r = (annualInterestRate/12)/100;
        int n = loanTerm*12;
        double aux=Math.pow((1+r),n);
        double M = (loanAmount*((r*aux)/(aux-1)));

        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator('.');
        DecimalFormat df = new DecimalFormat("#.##", symbols);
        return Double.parseDouble(df.format(M));
    }

    public List<Double> simulation(int loanAmount, int loanterm, double annualInterestRate) {

        double r = (annualInterestRate/12)/100;
        int n = loanterm*12;
        double aux=Math.pow((1+r),n);
        double monthlyPayment = (loanAmount*((r*aux)/(aux-1))); //Valor Bruto (Sin comisiones)
        double lienInsurance = ((0.03)*monthlyPayment)/100;  //0.03% del valor de la mensualidad
        double fireInsurance = 20000;               // Siempre es 20.000
        double administrationCommission = (1*loanAmount)/100;   //1% del valor del prestamo
        double monthlyCost = monthlyPayment + lienInsurance + fireInsurance + administrationCommission;
        double totalCost = monthlyCost*(12*loanterm);
        return Arrays.asList(
                monthlyPayment,
                lienInsurance,
                fireInsurance,
                administrationCommission,
                monthlyCost,
                totalCost
        );
    }
}
