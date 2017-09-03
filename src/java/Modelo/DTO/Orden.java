/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DTO;

import java.util.Date;

/**
 *
 * @author Junior Alvarez
 */
public class Orden
{
    private int idorden ;
    private String login ;
    private Date fechaOrden ;
    private double precioTotal ;
    private int estado ;

    public Orden(int idorden, String login, Date fechaOrden, double precioTotal, int estado)
    {
        this.idorden = idorden;
        this.login = login;
        this.fechaOrden = fechaOrden;
        this.precioTotal = precioTotal;
        this.estado = estado;
    }

    public Orden(String login, double prixTotale)
    {
        this.login = login;
        this.fechaOrden = fechaOrden;
        this.precioTotal = prixTotale;
        this.estado = estado;
    }

    /**
     * @return the idorden
     */
    public int getIdorden() {
        return idorden;
    }

    /**
     * @param idorden the idorden to set
     */
    public void setIdorden(int idorden) {
        this.idorden = idorden;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the fechaOrden
     */
    public Date getFechaOrden() {
        return fechaOrden;
    }

    /**
     * @param fechaOrden the fechaOrden to set
     */
    public void setFechaOrden(Date fechaOrden) {
        this.fechaOrden = fechaOrden;
    }

    /**
     * @return the precioTotal
     */
    public double getPrecioTotal() {
        return precioTotal;
    }

    /**
     * @param precioTotal the precioTotal to set
     */
    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    /**
     * @return the estado
     */
    public int getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(int estado) {
        this.estado = estado;
    }
    
}
