package com.prestabanco.PrestaBanco;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.prestabanco.PrestaBanco.Services.IMCSimulationService;
import com.prestabanco.PrestaBanco.Services.MCSimulationService;


class PrestaBancoApplicationTests {

	@Test
	void testMortageAmount() {
        IMCSimulationService simulator = new MCSimulationService();

        assertEquals(
            71.56, 
            simulator.simulateMortgageCredit(10000, 12, 0.5), 
            "No está calculando bien el monto del credito"
        );
	}

	@Test
	void testMortageSimulationWithZeroInterest() {
        IMCSimulationService simulator = new MCSimulationService();

        IllegalArgumentException error = assertThrows(
            IllegalArgumentException.class, () -> {
                simulator.simulateMortgageCredit(100000, 2, 0.0);
            }, 
            "Deberia de tirar error al simular con interes 0%"
        );
        assertEquals("No se puede simular un interes de 0%", error.getMessage());
	}
}
