package com.endes;

import java.util.ArrayList;
import java.util.List;

import com.endes.dao.ProductDAO;
import com.endes.servicio.ProductManager;
/**
 * Gestor de Productos
 */
public class ProductManagerImpl implements ProductManager {

	List<Product> productos = new ArrayList<Product>();
	private ProductDAO productDAO = new ProductDAO();
	
	
	public void crearTabla() {
		try {
			productDAO.crearTabla();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	/**
	 * Método que permite añadir un producto
	 * @param name El nombre no puede estar vacio o nulo
	 * @param price El precio tiene que ser mayor o igual que 0
	 */
	@Override
	public void addProduct(String name, double price) {
		Product nuevo = new Product(name, price);
		productos.add(nuevo);
	}

	/**
	 * Método que permite mostrar un listado de productos
	 */
	@Override
	public void listProducts() {
		try {
			if (productos.isEmpty()) {
				throw new Exception("No hay productos para listar.");
			}
			for (int i = 0; i < productos.size(); i++) {
				System.out.println("Producto " + (i + 1) + ": " + productos.get(i).getName() + " - Precio: " + productos.get(i).getPrice());
			}
		} catch (Exception e) {
			System.out.println("Error en listProducts: " + e.getMessage());
		}
	}

	/**
	 * Método que permite buscar un producto por su nombre
	 * @param searchName Palabra clave a buscar
	 */
	@Override
	public void findProduct(String searchName) {
		boolean found = false;
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getName().equalsIgnoreCase(searchName)) {
                System.out.println("Producto encontrado: " + productos.get(i).getName() + " - Precio: " + productos.get(i).getPrice());
                found = true;
                break;
            }
        }
        if (!found) {
            try {
                throw new Exception("Producto no encontrado: " + searchName);
            } catch (Exception e) {
                System.out.println("Error en findProduct: " + e.getMessage());
            }
        }

	}

}
