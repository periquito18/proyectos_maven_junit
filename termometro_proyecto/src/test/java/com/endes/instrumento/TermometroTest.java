package com.endes.instrumento;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TermometroTest {
	
	Termometro termometro;

	@BeforeEach
	void setUp() throws Exception {
		termometro = new Termometro(0.0);
	}

	@Test
	@DisplayName("Prueba del Constructor")
	void testConstructor() {
		double resultadoEsperado = 0.0;
		double resultado = termometro.getTemperaturaCelsius();
		
		assertEquals(resultadoEsperado, resultado, "No es igual al obtener el valor del pasado al constructor");
	}
	
	@Test
	@DisplayName("Prueba de Setter de Termometro")
	void testSetterTermometro() {
		double resultadoEsperado = -1;
		termometro.setTemperaturaCelsius(-1);
		double resultado = termometro.getTemperaturaCelsius();
		
		assertEquals(resultadoEsperado, resultado, "Erorr al realizar el setter");
		
	}

}
