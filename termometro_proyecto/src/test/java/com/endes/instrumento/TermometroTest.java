package com.endes.instrumento;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TermometroTest {

	Termometro termometro;
	@BeforeEach
	void setUp() throws Exception {
		termometro = new Termometro(0.0);
	}

	@Test
	void testConstructor() {
		double resultadoEsperado = 0.0;
		
		double resultado = termometro.getTemperaturaCelsius();
		
		assertEquals(resultadoEsperado, resultado);
	}

}
