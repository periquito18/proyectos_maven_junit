package com.endes;

import com.endes.servicio.ProductManager;

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
		gestorDeProductos.addProduct("Monitor", 250);
		gestorDeProductos.addProduct("Teclado", 50);
		gestorDeProductos.addProduct("Mouse", 25);
		gestorDeProductos.addProduct("Impresora", 150);
		gestorDeProductos.listProducts();
		gestorDeProductos.findProduct("Teclado");
		gestorDeProductos.findProduct("Scanner"); // Producto inexistente para provocar error
		
	}

}
