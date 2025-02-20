package com.endes.servicio;

import com.endes.entidad.Product;
import com.endes.exception.ProductNotFoundException;
import java.util.List;

/**
 * Interfaz que define las operaciones de negocio para gestionar productos.
 * (Capa intermedia entre el DAO y la presentación)
 */
public interface ProductManager {

    /**
     * Crea la tabla 'product' si no existe.
     */
    void crearTabla();

    /**
     * Añade (Crea) un nuevo producto.
     * 
     * @param name  Nombre del producto.
     * @param price Precio del producto.
     */
    void addProduct(String name, double price);

    /**
     * Lista (Lee) todos los productos.
     * 
     * @return Lista de productos.
     */
    List<Product> listProducts();

    /**
     * Busca (Lee) un producto por nombre.
     * 
     * @param searchName Nombre a buscar.
     * @return El producto encontrado.
     * @throws ProductNotFoundException Si no se encuentra el producto.
     */
    Product findProduct(String searchName) throws ProductNotFoundException;

    /**
     * Actualiza (Update) el precio de un producto, buscándolo por su nombre.
     * 
     * @param name      Nombre del producto.
     * @param newPrice  Nuevo precio a asignar.
     * @throws ProductNotFoundException Si el producto no se encuentra.
     */
    void updateProductPrice(String name, double newPrice) throws ProductNotFoundException;

    /**
     * Elimina (Delete) un producto de la base de datos, buscándolo por nombre.
     * 
     * @param name Nombre del producto.
     * @throws ProductNotFoundException Si el producto no se encuentra.
     */
    void deleteProduct(String name) throws ProductNotFoundException;
}
