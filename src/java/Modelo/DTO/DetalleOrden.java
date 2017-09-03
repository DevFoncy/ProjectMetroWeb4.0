/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DTO;

/**
 *
 * @author Junior Alvarez
 */
public class DetalleOrden
{
private int idorden ;
private int idproducto ;
private int nbr;

    public DetalleOrden(int idOrden, int idProducto, int nbr)
    {
        this.idorden = idOrden;
        this.idproducto = idProducto;
        this.nbr = nbr;
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
     * @return the nbr
     */
    public int getNbr() {
        return nbr;
    }

    /**
     * @param nbr the nbr to set
     */
    public void setNbr(int nbr) {
        this.nbr = nbr;
    }

}
