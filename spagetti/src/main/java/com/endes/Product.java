package com.endes;

public class Product {

	private String name;
	private double price;

	/**
	 * Constructor de Producto 
	 * @param name El nombre no puede estar vacio o nulo
	 * @param price El precio tiene que ser mayor o igual que 0
	 */
	public Product(String name, double price) {
		if (name == null || name.trim().isEmpty()) {
			throw new IllegalArgumentException("Error: Nombre inválido");
		}
		if (price < 0) {
			throw new IllegalArgumentException("Error: Precio negativo");
		}

		this.name= name;
		this.price = price;
	}

	public Product() {
		super();
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + "]";
	}
	
	

}
