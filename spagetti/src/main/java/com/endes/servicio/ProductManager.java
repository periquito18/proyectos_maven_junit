package com.endes.servicio;

public interface ProductManager {
	 public void addProduct(String name, double price);
	 public void listProducts();
	 public void findProduct(String searchName);
}
