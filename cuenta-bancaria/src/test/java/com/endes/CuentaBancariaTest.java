package com.endes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CuentaBancariaTest {
	
	private CuentaBancaria cuenta;

     @BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Antes de todas las pruebas");
	}

	@BeforeEach
	void setUp() throws Exception {
		cuenta = new CuentaBancaria(1000);
	}

	/* ###########################
	 * # Pruebas del Constructor #
	 * ###########################
	 */
	 @Test
	 @DisplayName("El saldo inicial debe corresponder con el pasado por el constructor.")
	 void testConstructorSaldoValido() {
		Double valorEsperado =1000.0;
		
	    assertEquals(valorEsperado, cuenta.getSaldo());
	  }
	
	 @Test
	 @DisplayName("El saldo inicial no puede ser negativo")
	 void testConstructorSaldoInvalido() {
	   String mensajeEsperado = "El saldo inicial no puede ser negativo.";
	   Exception exception = assertThrows(IllegalArgumentException.class, () -> new CuentaBancaria(-100));
	        
	   assertEquals(mensajeEsperado, exception.getMessage(), "La excepción del constructor envia otro mensaje");
	   
	 }
	 /* ######################
	  * # Metodo depositar   #
		######################
	*/
	 
	 //@Test ---> Para repetir 3 veces
	 @RepeatedTest(3)
	 @DisplayName("Depositar saldo positivo")
	  void testDepositoValido() {
		 
		Double valorEsperado = 1500.0;
		
	    assertEquals(valorEsperado, cuenta.depositar(500));
	 }
	 
	 
	 @Test
	 @DisplayName("La cantidad a depositar debe ser positiva")
	    void testDepositoInvalido() {
		 	String mensajeEsperado = "La cantidad a depositar debe ser positiva.";
	        Exception exception = assertThrows(IllegalArgumentException.class, () -> cuenta.depositar(-100));
	        assertEquals(mensajeEsperado, exception.getMessage());
	    }
	 
	 @Test
	 @DisplayName("Depositar 0 debe lanzar una excepción")
	 void testDepositoCero() {
	     String mensajeEsperado = "La cantidad a depositar debe ser positiva.";
	     Exception exception = assertThrows(IllegalArgumentException.class, () -> cuenta.depositar(0));
	     assertEquals(mensajeEsperado, exception.getMessage());
	 }
	 /* ######################
	  * # Metodo retirar   #
		######################
	*/
	 
	 @Test
	 @DisplayName("Retiro válido")
	 void testRetiroValido() {
		 Double resultadoEsperado = 500.0;
	   	 assertEquals(resultadoEsperado, cuenta.retirar(500));
	  }
	 
	 
	 @Test
	 @DisplayName("Fondos insuficientes para retirar.")
	 void testFondosInsuficientes() {
		 String mensajeEsperado = "Fondos insuficientes para retirar.";
		 Exception exception = assertThrows(IllegalArgumentException.class, () -> cuenta.retirar(1500));
		 assertEquals(mensajeEsperado, exception.getMessage());
	 }
	 
	 @Test
	 @DisplayName("La cantidad a retirar debe ser positiva.")
	 void testRetirarCantidadNegativa() {
		 String mensajeEsperado = "La cantidad a retirar debe ser positiva.";
		 Exception exception = assertThrows(IllegalArgumentException.class, () -> cuenta.retirar(-100));
		 assertEquals(mensajeEsperado, exception.getMessage());
	 }
	 @Test
	 @DisplayName("Retirar todo el saldo disponible")
	 void testRetirarTodoSaldo() {
	     Double saldoEsperado = 0.0;
	     assertEquals(saldoEsperado, cuenta.retirar(1000));
	 }
	 @Test
	 @DisplayName("Retirar exactamente el saldo disponible debe dejar el saldo en 0")
	 void testRetirarSaldoExacto() {
	     Double saldoEsperado = 0.0;
	     assertEquals(saldoEsperado, cuenta.retirar(1000.0));
	 }
	 
	 @Test
	 @DisplayName("El saldo no debe cambiar si ocurre una excepción")
	 void testEstadoConsistente() {
	     double saldoInicial = cuenta.getSaldo();
	     try {
	         cuenta.retirar(1500); // Esto lanza una excepción
	     } catch (IllegalArgumentException e) {
	         // Ignorar la excepción aquí
	     }
	     assertEquals(saldoInicial, cuenta.getSaldo(), "El saldo cambió tras lanzar la excepción.");
	 }

	 @DisplayName("Pruebas parametrizadas para depósitos válidos")
	 void testDepositosValidos(double deposito, double saldoEsperado) {
	     cuenta.depositar(deposito);
	     assertEquals(saldoEsperado, cuenta.getSaldo());
	 }
	 /** Secuencias */
	 @Test
	 @DisplayName("Secuencia de operaciones de depósito y retiro")
	 void testSecuenciaOperaciones() {
	     cuenta.depositar(500);
	     cuenta.retirar(300);
	     Double saldoEsperado = 1200.0;
	     assertEquals(saldoEsperado, cuenta.getSaldo());
	 }
	 
	 /**
	  * Hay que añadir  <artifactId>junit-jupiter-params</artifactId>
	  * ##
	  * #  Pruebas parametrizdas
	  */
	 @ParameterizedTest
	    @CsvSource({
	        "100, 1100",
	        "200, 1200",
	        "300, 1300"
	    })
	    void testDepositos(double cantidad, double saldoEsperado) {
	        CuentaBancaria cuenta = new CuentaBancaria(1000);
	        cuenta.depositar(cantidad);
	        assertEquals(saldoEsperado, cuenta.getSaldo());
	    }
	 /** Valores límite */
	 


	 @Test
	 @DisplayName("Depósito cercano al límite de precisión de double")
	 void testDepositoPrecision() {
		 Double valorEsperado = 1000.0 + Double.MIN_VALUE;
		 
	     cuenta.depositar(Double.MIN_VALUE);
	     
	     assertEquals(valorEsperado, cuenta.getSaldo());
	 }
	 

	 
	 /**Hilos*/
	 @Test
	 @DisplayName("Operaciones concurrentes de depósito y retiro")
	 void testConcurrencia() throws InterruptedException {
	     int hilos = 100;
	     Thread[] threads = new Thread[hilos];
	     for (int i = 0; i < hilos; i++) {
	         threads[i] = new Thread(() -> {
	             cuenta.depositar(10);
	             cuenta.retirar(10);
	         });
	         threads[i].start();
	     }
	     for (Thread thread : threads) {
	         thread.join();
	     }
	     assertEquals(1000.0, cuenta.getSaldo());
	 }
	 
	 @Test
	 @DisplayName("Concurrencia en operaciones de depósito y retiro")
	 void testConcurrenciaRobusta() throws InterruptedException {
	     ExecutorService executor = Executors.newFixedThreadPool(10);
	     for (int i = 0; i < 100; i++) {
	         executor.execute(() -> {
	             cuenta.depositar(10);
	             cuenta.retirar(10);
	         });
	     }
	     executor.shutdown();
	     executor.awaitTermination(1, TimeUnit.SECONDS);

	     assertEquals(1000.0, cuenta.getSaldo(), "El saldo no es consistente tras operaciones concurrentes.");
	 }

}
