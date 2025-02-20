package com.endes.exception;

/**
 * Excepción para indicar que un producto no ha sido encontrado.
 * 
 * @author ...
 */
public class ProductNotFoundException extends Exception {

    private static final long serialVersionUID = 1L;

    public ProductNotFoundException(String message) {
        super(message);
    }
}