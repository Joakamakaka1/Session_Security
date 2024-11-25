package com.es.seguridadsession.model;


import jakarta.persistence.*;

/**
 * The type Producto.
 */
@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private int stock;
    private boolean precio;

    /**
     * Instantiates a new Producto.
     */
    public Producto(){}

    /**
     * Instantiates a new Producto.
     *
     * @param id     the id
     * @param nombre the nombre
     * @param stock  the stock
     * @param precio the precio
     */
    public Producto(Long id, String nombre, int stock, boolean precio) {
        this.id = id;
        this.nombre = nombre;
        this.stock = stock;
        this.precio = precio;
    }

    /**
     * Instantiates a new Producto.
     *
     * @param nombre the nombre
     * @param stock  the stock
     * @param precio the precio
     */
    public Producto(String nombre, int stock, boolean precio) {
        this.nombre = nombre;
        this.stock = stock;
        this.precio = precio;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
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
