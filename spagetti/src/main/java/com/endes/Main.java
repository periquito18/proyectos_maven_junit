package com.endes;

import com.endes.servicio.ProductManager;
import com.github.javafaker.Faker;

public class Main {

	public static void main(String[] args) {
		ProductManager gestorDeProductos = new ProductManagerImpl();
		gestorDeProductos.crearTabla();
	}
	/**
	 * Crea products fake
	 */
	public static void productManager() {
		ProductManager gestorDeProductos = new ProductManagerImpl();
		Faker faker = new Faker();
		for(int i=0; i<100; i++) {
			gestorDeProductos.addProduct(faker.commerce().productName(), faker.number().numberBetween(3, 199));
		}
		
		
		gestorDeProductos.listProducts();
		
	}

}
