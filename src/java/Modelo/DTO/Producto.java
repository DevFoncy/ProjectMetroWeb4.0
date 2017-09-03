/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DTO;

import java.util.Date;

/**
 *
 * @author Juniior Alvarez
 */
public class Producto
{
    private int idproducto ;
    private String nombre ;
    private String descripcion ;
    private double precio ; 
    private String imagen ;
    private int cantidad ;
    private Date fechaCreacion ;

    public Producto()
    {
    }
    
    public Producto(String libelle, String desc, double prix, String img, int qte)
    {
        this.nombre = libelle;
        this.descripcion = desc;
        this.precio = prix;
        this.imagen = img;
        this.cantidad = qte;
    }

    public Producto(int idArticle, String libelle, String desc, double prix, String img, int qte, Date dateAjout)
    {
        this.idproducto = idArticle;
        this.nombre = libelle;
        this.descripcion = desc;
        this.precio = prix;
        this.imagen = img;
        this.cantidad = qte;
        this.fechaCreacion = dateAjout;
    }

    /**
     * @return the idproducto
     */
    public int getIdproducto() {
        return idproducto;
    }

    /**
     * @param idproducto the idproducto to set
     */
    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * @return the imagen
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * @param imagen the imagen to set
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the fechaCreacion
     */
    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     * @param fechaCreacion the fechaCreacion to set
     */
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    
     @Override
    public String toString() {
        return "Producto{" + "idproducto=" + idproducto + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio + ", imagen=" + imagen + ", cantidad=" + cantidad + ", fechaCreacion=" + fechaCreacion + '}';
    }
    
}
