package com.endes;

import com.endes.servicio.ProductManager;
import com.github.javafaker.Faker;

public class Main {

	public static void main(String[] args) {
		/**
		SpaghettiProducts sp = new SpaghettiProducts();
        sp.addProduct("Monitor", 250);
        sp.addProduct("Teclado", 50);
        sp.addProduct("Mouse", 25);
        sp.addProduct("Impresora", 150); // Debería activar la conversión de arrays a listas
        sp.listProducts();
        sp.findProduct("Teclado");
        sp.findProduct("Scanner"); // Producto inexistente para provocar error
*/
		
		ProductManager gestorDeProductos = new ProductManagerImpl();
		Faker faker = new Faker();
		for(int i=0; i<100; i++) {
			System.out.println(faker.chuckNorris().fact());
			gestorDeProductos.addProduct(faker.commerce().productName(), faker.number().numberBetween(3, 199));
		}
		
		
		gestorDeProductos.listProducts();
		/*gestorDeProductos.findProduct("Teclado");
		gestorDeProductos.findProduct("Scanner"); // Producto inexistente para provocar error
		*/
		
	}

}
