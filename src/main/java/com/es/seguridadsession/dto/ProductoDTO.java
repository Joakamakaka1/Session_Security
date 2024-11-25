package com.es.seguridadsession.dto;

/**
 * The type Producto dto.
 */
public class ProductoDTO {
    private String nombre;
    private int stock;
    private boolean precio;

    /**
     * Instantiates a new Producto dto.
     */
    public ProductoDTO(){}

    /**
     * Instantiates a new Producto dto.
     *
     * @param nombre the nombre
     * @param stock  the stock
     * @param precio the precio
     */
    public ProductoDTO(String nombre, int stock, boolean precio) {
        this.nombre = nombre;
        this.stock = stock;
        this.precio = precio;
    }

    /**
     * Gets nombre.
     *
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Sets nombre.
     *
     * @param nombre the nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Gets stock.
     *
     * @return the stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * Sets stock.
     *
     * @param stock the stock
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * Is precio boolean.
     *
     * @return the boolean
     */
    public boolean isPrecio() {
        return precio;
    }

    /**
     * Sets precio.
     *
     * @param precio the precio
     */
    public void setPrecio(boolean precio) {
        this.precio = precio;
    }
}
