package com.prestabanco.PrestaBanco;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
            "Paso algo mal"
        );
	}

}
