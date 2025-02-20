package com.endes;

import java.util.List;

import com.endes.dao.ProductDAO;
import com.endes.entidad.Product;
import com.endes.exception.ProductNotFoundException;
import com.endes.servicio.ProductManager;
import com.endes.servicio.ProductManagerImpl;
import com.github.javafaker.Faker;

public class Main {

	public static void main(String[] args) {
	    ProductDAO productDAO = new ProductDAO();

	    // Crear tabla
	    productDAO.crearTabla();
	   
	    // Insertar producto sin cerrar la conexión antes
	    productDAO.insertProduct(new Product("Camiseta", 19.99));

	    // Al final, cuando ya no necesites la base de datos...
	    productDAO.close(); 
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
